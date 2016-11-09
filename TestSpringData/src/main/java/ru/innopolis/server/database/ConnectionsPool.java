package ru.innopolis.server.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.server.configs.DBConfig;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Arxan on 28.10.2016.
 */
public class ConnectionsPool {
	private static final ConnectionsPool INSTANCE = new ConnectionsPool();
	private static final Logger logger = LoggerFactory.getLogger(ConnectionsPool.class);

	private final Queue<Connection> pool = new LinkedList<>();
	private int baseCount;
	private int maxCount;
	private int initCount;
	private String dbURL;
	private String dbLogin;
	private String dbPassword;

	private ConnectionsPool () {
		this.baseCount = DBConfig.DB_CONNECTIONPOOL_BASE_COUNT;
		this.maxCount = DBConfig.DB_CONNECTIONPOOL_MAX_COUNT;
		this.initCount = 0;
		this.dbURL = DBConfig.DB_URL;
		this.dbLogin = DBConfig.DB_LOGIN;
		this.dbPassword = DBConfig.DB_PASSWORD;
	}

	public static ConnectionsPool getInstance() {
		return INSTANCE;
	}

	public Queue<Connection> getPool() {
		return pool;
	}

	public int getBaseCount() {
		return baseCount;
	}

	public void setBaseCount(int baseCount) {
		this.baseCount = baseCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public String getDbURL() {
		return dbURL;
	}

	public String getDbLogin() {
		return dbLogin;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public int getInitCount() {
		return initCount;
	}

	public void setInitCount(int initCount) {
		this.initCount = initCount;
	}
}
