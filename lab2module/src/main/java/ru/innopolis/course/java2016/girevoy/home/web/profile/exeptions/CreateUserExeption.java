package ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions;

/**
 * Created by Arxan on 28.10.2016.
 */
public class CreateUserExeption extends Exception{
	public CreateUserExeption() {
		super();
	}
	public CreateUserExeption(String msg) {
		super(msg);
	}
	public CreateUserExeption(String message, Throwable cause) {
		super(message, cause);
	}
	public CreateUserExeption(Throwable cause) {
		super(cause);
	}

}
