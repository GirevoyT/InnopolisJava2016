package ru.innopolis.server.database;

import ru.innopolis.server.database.exeptions.NoFreeConnectionExeption;

import java.sql.Connection;

/**
 * Created by Arxan on 31.10.2016.
 */
public interface ConnectionPoolService {
	/**
	 * Получить конект из пула
	 * @return
	 * @throws NoFreeConnectionExeption
	 */
	public Connection getConnection() throws NoFreeConnectionExeption;

	/**
	 * Получить конект из пула с ожиданием при необходимости (стандартное время)
	 * @return
	 * @throws NoFreeConnectionExeption
	 */
	public Connection getConnectionWithWait() throws NoFreeConnectionExeption;

	/**
	 * Получить конект из пула с ожиданием при необходимости (указанное время)
	 * @param timeout вмемя ожидания
	 * @return
	 * @throws NoFreeConnectionExeption
	 */
	public Connection getConnectionWithWait(long timeout) throws NoFreeConnectionExeption;

	/**
	 * Вернуть конект в пулл
	 * @param connection
	 */
	public void returnConnection(Connection connection);
}
