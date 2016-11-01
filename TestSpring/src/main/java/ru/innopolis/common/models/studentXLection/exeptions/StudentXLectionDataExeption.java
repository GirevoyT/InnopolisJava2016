package ru.innopolis.common.models.studentXLection.exeptions;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public class StudentXLectionDataExeption extends Exception {
	public StudentXLectionDataExeption() {
	}

	public StudentXLectionDataExeption(String message) {
		super(message);
	}

	public StudentXLectionDataExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentXLectionDataExeption(Throwable cause) {
		super(cause);
	}

	public StudentXLectionDataExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
