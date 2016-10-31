package ru.innopolis.server.database;

import ru.innopolis.server.database.exeptions.NoFreeConnectionExeption;

import java.sql.Connection;

/**
 * Created by Arxan on 31.10.2016.
 */
public interface ConnectionPoolService {
	public Connection getConnection() throws NoFreeConnectionExeption;
	public Connection getConnectionWithWait() throws NoFreeConnectionExeption;
	public Connection getConnectionWithWait(long timeout) throws NoFreeConnectionExeption;
	public void returnConnection(Connection connection);
}
