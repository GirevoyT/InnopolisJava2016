package ru.innopolis.loggerhelp;

import org.slf4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

	/**
	 * Метод по выводу стак трейса ошибки e в логгер WARN
	 * @param e ошбика трейс которой необходимо выдать
	 * @param logger логгер в который надо выдать ошибку
	 */
	public static void printExeptionInWarn(Exception e, Logger logger){
		if (logger.isWarnEnabled()) {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			PrintStream printStream = new PrintStream(byteArrayOutputStream);
			e.printStackTrace(printStream);
			logger.warn(byteArrayOutputStream.toString());
		}
	}
}
