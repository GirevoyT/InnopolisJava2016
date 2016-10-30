package ru.innopolis.course.java2016.girevoy.home.security.exeptions;

/**
 * Created by Arxan on 30.10.2016.
 */
public class AesCryptExeption extends Exception {
	public AesCryptExeption() {
		super();
	}
	public AesCryptExeption(String msg) {
		super(msg);
	}
	public AesCryptExeption(String message, Throwable cause) {
		super(message, cause);
	}
	public AesCryptExeption(Throwable cause) {
		super(cause);
	}
}
