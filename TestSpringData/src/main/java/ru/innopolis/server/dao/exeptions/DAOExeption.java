package ru.innopolis.server.dao.exeptions;

/**
 * Created by Arxan on 31.10.2016.
 */
public class DAOExeption extends Exception {
	public DAOExeption() {
	}

	public DAOExeption(String message) {
		super(message);
	}

	public DAOExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOExeption(Throwable cause) {
		super(cause);
	}

	public DAOExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
