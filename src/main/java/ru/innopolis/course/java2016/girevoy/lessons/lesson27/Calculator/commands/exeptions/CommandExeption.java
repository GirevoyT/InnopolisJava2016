package ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.commands.exeptions;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
public class CommandExeption extends Exception {
	public CommandExeption() {
	}

	public CommandExeption(String message) {
		super(message);
	}

	public CommandExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandExeption(Throwable cause) {
		super(cause);
	}

	public CommandExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
