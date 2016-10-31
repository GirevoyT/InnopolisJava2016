package ru.innopolis.database.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.config.DBConfig;
import ru.innopolis.database.exeptions.AddConectionToPoolExeption;
import ru.innopolis.database.exeptions.NoFreeConnectionExeption;
import ru.innopolis.database.models.ConnectionsPool;
import ru.innopolis.loggerhelp.LoggerHelp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Arxan on 28.10.2016.
 */
public class ConnectionsPoolService {
	private static final ConnectionsPool connectionsPool;
	private static final Logger logger = LoggerFactory.getLogger(ConnectionsPool.class);
	static {
		connectionsPool = ConnectionsPool.getInstance();
		synchronized (connectionsPool) {
			for (int i=0;i <connectionsPool.getBaseCount();i++) {
				try {
					addNewConnection();
				} catch (AddConectionToPoolExeption e) {
					LoggerHelp.printExeptionInError(e,logger);
					throw new RuntimeException(e);
				}
			}
		}
	}

	/**
	 * Метод для получения конекта к бд из пула
	 * @return возвращает конект к бд
	 * @throws NoFreeConnectionExeption ошибка отсутствия подключений к бд
	 * @throws AddConectionToPoolExeption ошибка SQLExeption при попытке раширения пула
	 */
	public static Connection getConnection() throws NoFreeConnectionExeption, AddConectionToPoolExeption {
		Connection result = null;
		synchronized (connectionsPool) {
			if (connectionsPool.getPool().size() > 0) {
				result = connectionsPool.getPool().poll();
			} else if (connectionsPool.getInitCount() < connectionsPool.getMaxCount()) {
				addNewConnection();
				result = connectionsPool.getPool().poll();
			} else {
				throw new NoFreeConnectionExeption("Нет свободных коннектов");
			}
		}
		return result;
	}

	/**
	 * Метод для получения коннекта к бд из пула, при необходимости ждущий конекта заданное время
	 * @param miliseconds количество милесекунд ожидания
	 * @return возвращает коннект к бд
	 * @throws AddConectionToPoolExeption ошибка отсутствия подключений к бд
	 * @throws NoFreeConnectionExeption ошибка SQLExeption при попытке раширения пула
	 */
	public static Connection getConnectionWithWait (int miliseconds) throws AddConectionToPoolExeption, NoFreeConnectionExeption {
		Connection result = null;
		synchronized (connectionsPool) {
			if (connectionsPool.getPool().size() > 0) {
				result = connectionsPool.getPool().poll();
			} else if (connectionsPool.getInitCount() < connectionsPool.getMaxCount()) {
				addNewConnection();
				result = connectionsPool.getPool().poll();
			} else {
				try {
					connectionsPool.wait(miliseconds);
				} catch (InterruptedException e) {
					LoggerHelp.printExeptionInError(e,logger);
				}
				if (connectionsPool.getPool().size() > 0) {
					result = connectionsPool.getPool().poll();
				} else {
					throw new NoFreeConnectionExeption("Нет свободных коннектов");
				}
			}
		}
		return result;
	}

	/**
	 * Метод для получения коннекта к бд из пула, при необходимости ждущий конекта
	 * @return возвращает коннект к бд
	 * @throws AddConectionToPoolExeption ошибка отсутствия подключений к бд
	 * @throws NoFreeConnectionExeption ошибка SQLExeption при попытке раширения пула
	 */
	public static Connection getConnectionWithWait () throws AddConectionToPoolExeption, NoFreeConnectionExeption {
		return getConnectionWithWait(DBConfig.DB_WAIT_CONNECTION_FROM_POOL_TIME);
	}

	/**
	 * Метод для возврата конекта в пулл
	 * @param connection возвращаемый конект
	 */
	public static void returnConnection(Connection connection) {
		synchronized (connectionsPool) {
			connectionsPool.getPool().add(connection);
			connectionsPool.notify();
		}
	}

	/*
	 * Метод для добавление нового конекта в пулл
	 */
	private static void addNewConnection () throws AddConectionToPoolExeption {

		Connection tmp = null;
		try {
			tmp = DriverManager.getConnection(connectionsPool.getDbURL(),
															connectionsPool.getDbLogin(),
															connectionsPool.getDbPassword());
		} catch (SQLException e) {
			LoggerHelp.printExeptionInError(e,logger);
			throw new AddConectionToPoolExeption(e);
		}
		synchronized (connectionsPool) {
			connectionsPool.getPool().add(tmp);
			connectionsPool.setInitCount(connectionsPool.getInitCount() + 1);
		}
	}
}
