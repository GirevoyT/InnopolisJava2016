package ru.innopolis.course.java2016.girevoy.lessons.lesson27;

/**
 * Created by Arxan on 08.11.2016.
 */
public class ChainEllementExeption extends Exception {
	public ChainEllementExeption() {
	}

	public ChainEllementExeption(String message) {

		super(message);
	}

	public ChainEllementExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public ChainEllementExeption(Throwable cause) {
		super(cause);
	}

	public ChainEllementExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
