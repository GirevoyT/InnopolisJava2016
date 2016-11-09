package ru.innopolis.server.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.loggerhelp.LoggerHelp;
import ru.innopolis.server.configs.DBConfig;
import ru.innopolis.server.database.exeptions.AddConectionToPoolExeption;
import ru.innopolis.server.database.exeptions.NoFreeConnectionExeption;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Arxan on 28.10.2016.
 */
public class ConnectionsPoolServiceImpl implements ConnectionPoolService{
	private final ConnectionsPool connectionsPool = ConnectionsPool.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(ConnectionsPoolServiceImpl.class);


	@Override
	public Connection getConnection() throws NoFreeConnectionExeption {
		Connection result = null;
		try {
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
		} catch (AddConectionToPoolExeption e) {
			throw new NoFreeConnectionExeption("Нет свободных коннектов(произошла ошибка во время создания нового)",e);
		}
		return result;
	}

	private void addNewConnection() throws AddConectionToPoolExeption {
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

	@Override
	public Connection getConnectionWithWait() throws NoFreeConnectionExeption {
		return getConnectionWithWait(DBConfig.DB_WAIT_CONNECTION_FROM_POOL_TIMEOUT);
	}

	@Override
	public Connection getConnectionWithWait(long timeout) throws NoFreeConnectionExeption {
		Connection result = null;
		synchronized (connectionsPool) {
			try {
				if (connectionsPool.getPool().size() > 0) {
					result = connectionsPool.getPool().poll();
				} else if (connectionsPool.getInitCount() < connectionsPool.getMaxCount()) {
					addNewConnection();
					result = connectionsPool.getPool().poll();
				} else {
					try {
						connectionsPool.wait(timeout);
					} catch (InterruptedException e) {
						LoggerHelp.printExeptionInError(e, logger);
					}
					if (connectionsPool.getPool().size() > 0) {
						result = connectionsPool.getPool().poll();
					} else {
						throw new NoFreeConnectionExeption("Нет свободных коннектов");
					}
				}
			} catch (AddConectionToPoolExeption e) {
				throw new NoFreeConnectionExeption("Нет свободных коннектов(произошла ошибка во время создания нового)",e);
			}
		}
		return result;
	}

	@Override
	public void returnConnection(Connection connection) {
		if (connection != null) {
			synchronized (connectionsPool) {
				connectionsPool.getPool().add(connection);
				connectionsPool.notify();
			}
		}
	}
}
