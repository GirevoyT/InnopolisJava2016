package ru.innopolis.web.config;

/**
 * Created by Girevoy.T on 03.11.2016.
 */

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.innopolis.common.models.lection.LectionService;
import ru.innopolis.common.models.student.StudentService;
import ru.innopolis.common.models.studentAttendences.StudentAttendanceService;
import ru.innopolis.common.models.studentXLection.StudentXLectionService;
import ru.innopolis.server.dao.attendance.DAOAttendance;
import ru.innopolis.server.dao.attendance.DAOAttendanceSpringData;
import ru.innopolis.server.dao.lection.DAOLection;
import ru.innopolis.server.dao.lection.DAOLectionSpringData;
import ru.innopolis.server.dao.student.DAOStudent;
import ru.innopolis.server.dao.student.DAOStudentImpl;
import ru.innopolis.server.database.ConnectionPoolService;
import ru.innopolis.server.database.ConnectionsPoolServiceImpl;
import ru.innopolis.server.models.ServiceLogger;
import ru.innopolis.server.models.lection.LectionServiceImpl;
import ru.innopolis.server.models.lection.LectionServiceImplDecorator;
import ru.innopolis.server.models.student.StudentServiceImpl;
import ru.innopolis.server.models.studentAttendences.StudentAttendanceServiceImpl;
import ru.innopolis.server.models.studentXLection.StudentXLectionServiceImpl;

import java.lang.reflect.Proxy;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ru.innopolis")
public class AppContextConfig {
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
		emFactory.setDataSource(dataSource());
		emFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		emFactory.setJpaVendorAdapter(jpaVendorAdapter());
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		emFactory.setJpaProperties(properties);
		emFactory.setPackagesToScan("ru.innopolis");
		return emFactory;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}


	@Bean
	DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://192.168.140.1\\dbo:1433;databaseName=TestBase");
		dataSource.setUsername("sa");
		dataSource.setPassword("Testarosa123");
		return dataSource;
	}

	@Bean(name = "connectionsPoolService",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public ConnectionPoolService connectionsPoolServiceImpl() {
		return new ConnectionsPoolServiceImpl();
	}
	@Bean(name = "daoStudent",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public DAOStudent daoStudent() {
		return new DAOStudentImpl();
	}
	@Bean(name = "daoAttendance",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public DAOAttendance daoAttendance() {
		return new DAOAttendanceSpringData();
	}
	@Bean(name = "daoLection",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public DAOLection daoLection() {
		return new DAOLectionSpringData();
	}
	@Bean(name = "studentAttendanceService",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public StudentAttendanceService studentAttendanceService() {
		return new StudentAttendanceServiceImpl();
	}

	@Bean(name = "studentService",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public StudentService studentService() {
		Object proxy = Proxy.newProxyInstance(
			AppContextConfig.class.getClassLoader(),
			new Class[]{ StudentService.class },
			new ServiceLogger()
		);
		return (StudentService)proxy;
	}

	@Bean(name = "studentService2",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public StudentService studentService2() {
		return new StudentServiceImpl();
	}

	@Bean(name = "lectionServiceComponent",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public LectionService lectionServiceComponent() {
		return new LectionServiceImpl();
	}
	@Bean(name = "lectionService",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public LectionService lectionService() {
		return new LectionServiceImplDecorator();
	}
	@Bean(name = "studentXLectionService",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public StudentXLectionService studentXLectionService() {
		return new StudentXLectionServiceImpl();
	}
}
