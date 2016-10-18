package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Arxan on 14.10.2016.
 */
public class ResourceChecker {
	private static Logger logger = LoggerFactory.getLogger(ResourceChecker.class);

	/**
	 * Метож который принимая строку адреса
	 * @param arg
	 * и треад групп
	 * @param threadGroup
	 * возвращает подходящий ресурс
	 * @return
	 */
	public static Resource createResourceBySting (String arg,ThreadGroup threadGroup){
		logger.debug("Запущен метод получения ресурса");
		Resource result = null;
		if (isFile(arg)) {
			result = new SafetyFileResource(arg,threadGroup);
			logger.debug("Ресурс оказался файлом {}",arg);
		} else if (isURL(arg)) {
			try {
				result = new SafetyURLResource(arg,threadGroup);
				logger.debug("Ресурс оказался ссылкой {}",arg);
			} catch (MalformedURLException e) {
				logger.warn("Метод вошел в if (isURL(arg)) когда не мог это сделать");
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * Метод проверяет существует ли файл с таким именем
	 * @param arg
	 * @return
	 */
	public static boolean isFile(String arg) {
		logger.debug("Запущенна проверка {} на isFile",arg);
		boolean result = false;
		if ((arg != null) && (new File(arg)).isFile()) {
			result = true;
		}
		return result;
	}
	/**
	 * Метод проверяет может ли строка являться ссылкой
	 * @param arg
	 * @return
	 */
	public static boolean isURL(String arg) {
		logger.debug("Запущенна проверка {} на isURL",arg);
		boolean result;
		try {
			new URL(arg);
			result = true;
		} catch (MalformedURLException e) {
			result = false;
		}
		return result;
/*		if ((arg != null) && (arg.substring(0,8).equals("https://") || arg.substring(0,7).equals("http://"))) {
			return true;
		}
		return false;*/
	}
}
