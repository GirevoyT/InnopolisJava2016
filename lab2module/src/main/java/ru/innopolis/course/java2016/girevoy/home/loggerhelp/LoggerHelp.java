package ru.innopolis.course.java2016.girevoy.home.loggerhelp;

import org.slf4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Arxan on 28.10.2016.
 */
public class LoggerHelp {
	/**
	 * Метод по выводу стак трейса ошибки e в логгер ERROR
	 * @param e ошбика трейс которой необходимо выдать
	 * @param logger логгер в который надо выдать ошибку
	 */
	public static void printExeptionInError(Exception e, Logger logger){
		if (logger.isErrorEnabled()) {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			PrintStream printStream = new PrintStream(byteArrayOutputStream);
			e.printStackTrace(printStream);
			logger.error(byteArrayOutputStream.toString());
		}
	}
}
