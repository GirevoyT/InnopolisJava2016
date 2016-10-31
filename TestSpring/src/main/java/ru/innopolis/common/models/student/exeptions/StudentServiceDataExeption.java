package ru.innopolis.common.models.student.exeptions;

/**
 * Created by Arxan on 31.10.2016.
 */
public class StudentServiceDataExeption extends Exception {
	public StudentServiceDataExeption() {
	}

	public StudentServiceDataExeption(String message) {
		super(message);
	}

	public StudentServiceDataExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentServiceDataExeption(Throwable cause) {
		super(cause);
	}

	public StudentServiceDataExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
