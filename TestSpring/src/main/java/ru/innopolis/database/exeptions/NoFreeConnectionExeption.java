package ru.innopolis.database.exeptions;

/**
 * Created by Arxan on 28.10.2016.
 */
public class NoFreeConnectionExeption extends Exception {
	public NoFreeConnectionExeption() {
		super();
	}
	public NoFreeConnectionExeption(String msg) {
		super(msg);
	}
	public NoFreeConnectionExeption(String message, Throwable cause) {
		super(message, cause);
	}
	public NoFreeConnectionExeption(Throwable cause) {
		super(cause);
	}

}
