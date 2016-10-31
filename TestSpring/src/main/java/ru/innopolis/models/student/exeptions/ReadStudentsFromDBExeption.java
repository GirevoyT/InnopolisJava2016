package ru.innopolis.models.student.exeptions;

/**
 * Created by Girevoy.T on 31.10.2016.
 */
public class ReadStudentsFromDBExeption extends Exception {
	public ReadStudentsFromDBExeption() {
		super();
	}
	public ReadStudentsFromDBExeption(String msg) {
		super(msg);
	}
	public ReadStudentsFromDBExeption(String message, Throwable cause) {
		super(message, cause);
	}
	public ReadStudentsFromDBExeption(Throwable cause) {
		super(cause);
	}
}
