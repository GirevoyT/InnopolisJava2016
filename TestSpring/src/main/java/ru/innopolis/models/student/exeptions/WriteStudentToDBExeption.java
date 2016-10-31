package ru.innopolis.models.student.exeptions;

/**
 * Created by Girevoy.T on 31.10.2016.
 */
public class WriteStudentToDBExeption extends Exception {
	public WriteStudentToDBExeption() {
		super();
	}
	public WriteStudentToDBExeption(String msg) {
		super(msg);
	}
	public WriteStudentToDBExeption(String message, Throwable cause) {
		super(message, cause);
	}
	public WriteStudentToDBExeption(Throwable cause) {
		super(cause);
	}
}
