package ru.innopolis.server.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.loggerhelp.LoggerHelp;

public class DBConfig {
	private static final Logger logger= LoggerFactory.getLogger(DBConfig.class);
	public static final String DB_URL;
	public static final String DB_LOGIN;
	public static final String DB_PASSWORD;
	public static final String DB_JDBC_DRIVER_CLASS;
	public static final int DB_CONNECTIONPOOL_BASE_COUNT;
	public static final int DB_CONNECTIONPOOL_MAX_COUNT;
	public static final int DB_WAIT_CONNECTION_FROM_POOL_TIMEOUT;
	static {
		DB_JDBC_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try {
			Class.forName(DB_JDBC_DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			LoggerHelp.printExeptionInError(e,logger);
			throw new RuntimeException(e);
		}
		DB_URL = "jdbc:sqlserver://192.168.140.1;databaseName=TestBase;";
		DB_LOGIN = "sa";
		DB_PASSWORD = "Testarosa123";
		DB_CONNECTIONPOOL_BASE_COUNT = 1;
		DB_CONNECTIONPOOL_MAX_COUNT = 3;
		DB_WAIT_CONNECTION_FROM_POOL_TIMEOUT = 1000;
	}
}
