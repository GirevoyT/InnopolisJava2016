package ru.innopolis.server.dao.attendance;

import ru.innopolis.common.models.attendance.Attendance;
import ru.innopolis.server.dao.student.exeptions.DAOExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public interface DAOAttendance {
	/**
	 * Метод для получения списка Attendance
	 * @return
	 * @throws DAOExeption
	 */
	public List<Attendance> getAttendacesList() throws DAOExeption;

	/**
	 * Метод для добавления Attendance в базу
	 * @param attendance
	 * @throws DAOExeption
	 */
	public void addNewAttendance(Attendance attendance) throws DAOExeption;

	/**
	 * Метод для убиления Attendance из базы
	 * @param attendance
	 * @throws DAOExeption
	 */
	public void deleteAttendance(Attendance attendance) throws DAOExeption;
}
