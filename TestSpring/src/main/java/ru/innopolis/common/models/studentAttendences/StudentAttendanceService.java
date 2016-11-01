package ru.innopolis.common.models.studentAttendences;

import ru.innopolis.common.models.studentAttendences.exeptions.StudentAttendanceDataExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public interface StudentAttendanceService {
	public List<StudentAttendance> getSudentAttendanceList() throws StudentAttendanceDataExeption;
}
