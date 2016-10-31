package ru.innopolis.common.models.student.exeptions;

/**
 * Created by Arxan on 31.10.2016.
 */
public class CreateStudentExeption extends Exception {
	public CreateStudentExeption() {
	}

	public CreateStudentExeption(String message) {
		super(message);
	}

	public CreateStudentExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateStudentExeption(Throwable cause) {
		super(cause);
	}

	public CreateStudentExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
