package ru.innopolis.server.dao.lection;

import ru.innopolis.common.models.lection.Lection;
import ru.innopolis.server.dao.exeptions.DAOExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public interface DAOLection {
	/**
	 * Метод для получения списка Лекций из базы
	 * @return
	 * @throws DAOExeption
	 */
	public List<Lection> getLectionsList() throws DAOExeption;

	public void addNewLection(Lection lection) throws DAOExeption;

	public void deleteLection(Lection lection) throws DAOExeption;
}
