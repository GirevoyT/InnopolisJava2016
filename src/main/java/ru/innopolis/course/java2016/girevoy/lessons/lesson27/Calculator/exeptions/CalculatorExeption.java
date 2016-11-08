package ru.innopolis.course.java2016.girevoy.lessons.lesson27.Calculator.exeptions;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
public class CalculatorExeption extends Exception {
	public CalculatorExeption() {
	}

	public CalculatorExeption(String message) {
		super(message);
	}

	public CalculatorExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public CalculatorExeption(Throwable cause) {
		super(cause);
	}

	public CalculatorExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
