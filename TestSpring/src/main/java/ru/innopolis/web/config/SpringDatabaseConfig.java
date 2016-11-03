package ru.innopolis.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by Girevoy.T on 03.11.2016.
 */
@Configuration
public class SpringDatabaseConfig {
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		driverManagerDataSource.setUrl("jdbc:sqlserver://192.168.140.1;databaseName=TestBase");
		driverManagerDataSource.setUsername("sa");
		driverManagerDataSource.setPassword("Testarosa123");
		return driverManagerDataSource;
	}
}
