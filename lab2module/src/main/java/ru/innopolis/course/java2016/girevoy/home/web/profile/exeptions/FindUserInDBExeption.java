package ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions;

/**
 * Created by Arxan on 30.10.2016.
 */
public class FindUserInDBExeption extends Exception {
	public FindUserInDBExeption() {
		super();
	}
	public FindUserInDBExeption(String msg) {
		super(msg);
	}
	public FindUserInDBExeption(String message, Throwable cause) {
		super(message, cause);
	}
	public FindUserInDBExeption(Throwable cause) {
		super(cause);
	}
}
