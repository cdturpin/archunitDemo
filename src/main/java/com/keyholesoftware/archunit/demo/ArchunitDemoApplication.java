package com.keyholesoftware.archunit.demo;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class ArchunitDemoApplication extends SpringBootServletInitializer {

	private static final String DBNAME = "demo";

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ArchunitDemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(ArchunitDemoApplication.class);
		sa.setLogStartupInfo(false);
		sa.run(args);
	}

	@RestController
	public static class ArchunitDemoController {

		@GetMapping("/")
		public String handler(Model model) {
			model.addAttribute("date", LocalDateTime.now());
			return "ArchunitDemoApplication is up and running!";
		}
	}

}
