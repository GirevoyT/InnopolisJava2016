package ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions;

/**
 * Created by Arxan on 30.10.2016.
 */
public class WriteUserToDBExeption extends Exception {
	public WriteUserToDBExeption() {
		super();
	}
	public WriteUserToDBExeption(String msg) {
		super(msg);
	}
	public WriteUserToDBExeption(String message, Throwable cause) {
		super(message, cause);
	}
	public WriteUserToDBExeption(Throwable cause) {
		super(cause);
	}
}
