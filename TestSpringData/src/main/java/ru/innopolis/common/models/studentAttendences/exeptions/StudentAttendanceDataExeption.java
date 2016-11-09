package ru.innopolis.common.models.studentAttendences.exeptions;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public class StudentAttendanceDataExeption extends Exception {
	public StudentAttendanceDataExeption() {
	}

	public StudentAttendanceDataExeption(String message) {
		super(message);
	}

	public StudentAttendanceDataExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentAttendanceDataExeption(Throwable cause) {
		super(cause);
	}

	public StudentAttendanceDataExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
