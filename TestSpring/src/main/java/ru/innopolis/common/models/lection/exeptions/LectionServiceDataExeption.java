package ru.innopolis.common.models.lection.exeptions;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public class LectionServiceDataExeption extends Exception{
	public LectionServiceDataExeption() {
	}

	public LectionServiceDataExeption(String message) {
		super(message);
	}

	public LectionServiceDataExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public LectionServiceDataExeption(Throwable cause) {
		super(cause);
	}

	public LectionServiceDataExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
