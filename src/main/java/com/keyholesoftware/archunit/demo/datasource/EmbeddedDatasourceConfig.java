package com.keyholesoftware.archunit.demo.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class EmbeddedDatasourceConfig implements DatasourceConfig {

	@Override
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setName("Northwind")
				.setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:/schema-Northwind-h2.sql")
				.addScript("classpath:/data-northwind-h2.sql")
				.build();
	}

}
