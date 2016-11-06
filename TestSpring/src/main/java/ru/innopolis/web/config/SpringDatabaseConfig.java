package ru.innopolis.web.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.innopolis.server.configs.DBConfig;

/**
 * Created by Girevoy.T on 03.11.2016.
 */
@Configuration
public class SpringDatabaseConfig {
	@Bean(name = "dataSource",
			autowire = Autowire.BY_NAME)
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(DBConfig.DB_JDBC_DRIVER_CLASS);
		driverManagerDataSource.setUrl(DBConfig.DB_URL);
		driverManagerDataSource.setUsername(DBConfig.DB_LOGIN);
		driverManagerDataSource.setPassword(DBConfig.DB_PASSWORD);
		return driverManagerDataSource;
	}
}
