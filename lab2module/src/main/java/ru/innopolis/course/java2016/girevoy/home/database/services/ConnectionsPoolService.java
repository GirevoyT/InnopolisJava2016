package ru.innopolis.course.java2016.girevoy.home.database.services;

import ru.innopolis.course.java2016.girevoy.home.database.exeptions.NoFreeConnectionExeption;
import ru.innopolis.course.java2016.girevoy.home.database.models.ConnectionsPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Arxan on 28.10.2016.
 */
public class ConnectionsPoolService {
	private static final ConnectionsPool connectionsPool;
	static {
		connectionsPool = ConnectionsPool.getInstance();
	}

	/**
	 * Метод для получения конекта к бд из пула
	 * @return возвращает конект к бд
	 * @throws NoFreeConnectionExeption ошибка отсутствия подключений к бд
	 */
	public static Connection getConnection() throws NoFreeConnectionExeption {
		Connection result = null;
		if (connectionsPool.getPool().size() > 0) {
			result = connectionsPool.getPool().poll();
		} else {
			throw new NoFreeConnectionExeption();
		}
		return result;
	}
	/*
	* Метод для добавление нового конекта в пулл
	 */
	private static void addNewConnection (ConnectionsPool connectionsPool) throws SQLException {
		Connection tmp = DriverManager.getConnection(connectionsPool.getDbURL(),
														connectionsPool.getDbLogin(),
														connectionsPool.getDbPassword());
		connectionsPool.getPool().add(tmp);
	}
}
