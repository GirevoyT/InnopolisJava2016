package ru.innopolis.server.dao.attendance;

import ru.innopolis.common.models.attendance.Attendance;
import ru.innopolis.server.dao.student.exeptions.DAOExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public interface DAOAttendance {
	public List<Attendance> getAttendacesList() throws DAOExeption;

	public void addNewAttendance(Attendance attendance) throws DAOExeption;

	public void deleteAttendance(Attendance attendance) throws DAOExeption;
}
