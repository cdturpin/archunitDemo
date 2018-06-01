package com.keyholesoftware.archunit.demo.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.GeneralCodingRules.USE_JAVA_UTIL_LOGGING;

import org.junit.runner.RunWith;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
public class LayeredArchRulesTest {
	
	
	JavaClasses classes = new ClassFileImporter()
			.withImportOption(ImportOption.Predefined.DONT_INCLUDE_JARS)
			.withImportOption(ImportOption.Predefined.DONT_INCLUDE_TESTS)
			.importPackages("com.keyholesoftware.archunit.demo");
			//.importClasspath();

	@ArchTest
	public static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

			.layer("Controllers").definedBy("com.keyholesoftware.archunit.demo.controller..").layer("Services")
			.definedBy("com.keyholesoftware.archunit.demo.service..").layer("Persistence")
			.definedBy("com.keyholesoftware.archunit.demo.persistence..")

			.whereLayer("Controllers").mayNotBeAccessedByAnyLayer().whereLayer("Services")
			.mayOnlyBeAccessedByLayers("Controllers").whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services");

	@ArchTest
	public static final ArchRule layer_dependencies_are_respected_with_exception = layeredArchitecture()

			.layer("Controllers").definedBy("com.keyholesoftware.archunit.demo.controller..").layer("Services")
			.definedBy("com.keyholesoftware.archunit.demo.service..").layer("Persistence")
			.definedBy("com.keyholesoftware.archunit.demo.persistence..")

			.whereLayer("Controllers").mayNotBeAccessedByAnyLayer().whereLayer("Services")
			.mayOnlyBeAccessedByLayers("Controllers").whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services")
;
			//.ignoreDependency(SomeMediator.class, ServiceViolatingLayerRules.class);

	@ArchTest
	public static void no_java_util_logging_as_method(JavaClasses classes) {
		noClasses().should(USE_JAVA_UTIL_LOGGING).check(classes);
	}

	@ArchTest
	public static void services_should_not_access_controllers(JavaClasses classes) {
		noClasses().that().resideInAPackage("..service..").should().accessClassesThat()
				.resideInAPackage("..controller..").check(classes);
	}

	@ArchTest
	public static void persistence_should_not_access_services(JavaClasses classes) {
		noClasses().that().resideInAPackage("..persistence..").should().accessClassesThat()
				.resideInAPackage("..service..").check(classes);
	}

	@ArchTest
	public static void services_should_only_be_accessed_by_controllers_or_other_services(JavaClasses classes) {
		classes().that().resideInAPackage("..service..").should().onlyBeAccessed()
				.byAnyPackage("..controller..", "..service..").check(classes);
	}
	
/*

	@Test
	public static void no_java_util_logging_as_method1(JavaClasses classes) {
		noClasses().should(USE_JAVA_UTIL_LOGGING).check(classes);
	}

	@Test
	public static void services_should_not_access_controllers1(JavaClasses classes) {
		noClasses().that().resideInAPackage("..service..").should().accessClassesThat()
				.resideInAPackage("..controller..").check(classes);
	}

	@Test
	public static void persistence_should_not_access_services1(JavaClasses classes) {
		noClasses().that().resideInAPackage("..persistence..").should().accessClassesThat()
				.resideInAPackage("..service..").check(classes);
	}

	@Test
	public static void services_should_only_be_accessed_by_controllers_or_other_services1(JavaClasses classes) {
		classes().that().resideInAPackage("..service..").should().onlyBeAccessed()
				.byAnyPackage("..controller..", "..service..").check(classes);
	}
*/

}
