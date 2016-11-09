package ru.innopolis.server.database.exeptions;

/**
 * Created by Arxan on 28.10.2016.
 */
public class AddConectionToPoolExeption extends Exception {
	public AddConectionToPoolExeption() {
		super();
	}
	public AddConectionToPoolExeption(String msg) {
		super(msg);
	}
	public AddConectionToPoolExeption(String message, Throwable cause) {
		super(message, cause);
	}
	public AddConectionToPoolExeption(Throwable cause) {
		super(cause);
	}
	public AddConectionToPoolExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
