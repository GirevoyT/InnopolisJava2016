package ru.innopolis.course.java2016.girevoy.home.database.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.database.exeptions.AddConectionToPoolExeption;
import ru.innopolis.course.java2016.girevoy.home.database.exeptions.NoFreeConnectionExeption;
import ru.innopolis.course.java2016.girevoy.home.database.models.ConnectionsPool;
import ru.innopolis.course.java2016.girevoy.home.loggerhelp.LoggerHelp;

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
				} catch (SQLException e) {
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
				try {
					addNewConnection();
					result = connectionsPool.getPool().poll();
				} catch (SQLException e) {
					LoggerHelp.printExeptionInError(e,logger);
					throw new AddConectionToPoolExeption(e);
				}
			} else {
				throw new NoFreeConnectionExeption();
			}
		}
		return result;
	}

	/**
	 * Метод для возврата конекта в пулл
	 * @param connection возвращаемый конект
	 */
	public static void returnConnection(Connection connection) {
		synchronized (connectionsPool) {
			connectionsPool.getPool().add(connection);
		}
	}
	/*
	* Метод для добавление нового конекта в пулл
	 */
	private static void addNewConnection () throws SQLException {
		Connection tmp = DriverManager.getConnection(connectionsPool.getDbURL(),
														connectionsPool.getDbLogin(),
														connectionsPool.getDbPassword());
		synchronized (connectionsPool) {
			connectionsPool.getPool().add(tmp);
			connectionsPool.setInitCount(connectionsPool.getInitCount() + 1);
		}
	}
}
