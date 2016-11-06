package ru.innopolis.common.models.studentAttendences;

import ru.innopolis.common.models.studentAttendences.exeptions.StudentAttendanceDataExeption;

import java.util.List;


public interface StudentAttendanceService {
	/**
	 * Получить список студентов с количеством посещений
	 * @return Список
	 * @throws StudentAttendanceDataExeption
	 */
	public List<StudentAttendance> getSudentAttendanceList() throws StudentAttendanceDataExeption;
}
