package ru.innopolis.course.java2016.girevoy.home.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.loggerhelp.LoggerHelp;

/**
 * Created by Arxan on 28.10.2016.
 */
public class DBConfig {
	private static final Logger logger= LoggerFactory.getLogger(DBConfig.class);
	public static final String DB_URL;
	public static final String DB_LOGIN;
	public static final String DB_PASSWORD;
	public static final int DB_CONNECTIONPOOL_BASE_COUNT;
	public static final int DB_CONNECTIONPOOL_MAX_COUNT;
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			LoggerHelp.printExeptionInError(e,logger);
			throw new RuntimeException(e);
		}
		DB_URL = "jdbc:sqlserver://192.168.140.1;databaseName=TestBD;";
		DB_LOGIN = "sa";
		DB_PASSWORD = "Testarosa123";
		DB_CONNECTIONPOOL_BASE_COUNT = 1;
		DB_CONNECTIONPOOL_MAX_COUNT = 3;
	}
}
