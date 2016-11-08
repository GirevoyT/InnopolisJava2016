package ru.innopolis.course.java2016.girevoy.lessons.lesson27;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
public class TimeToBreakExeption extends Exception {
	public TimeToBreakExeption() {
	}

	public TimeToBreakExeption(String message) {
		super(message);
	}

	public TimeToBreakExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public TimeToBreakExeption(Throwable cause) {
		super(cause);
	}

	public TimeToBreakExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
