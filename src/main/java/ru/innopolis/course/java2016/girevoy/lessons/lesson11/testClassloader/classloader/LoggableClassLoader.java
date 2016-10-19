package ru.innopolis.course.java2016.girevoy.lessons.lesson11.testClassloader.classloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by masterlomaster on 17.10.16.
 */
public class LoggableClassLoader extends ClassLoader {
	private static Logger logger = LoggerFactory.getLogger(LoggableClassLoader.class);

	public LoggableClassLoader(ClassLoader parent) {
		super(parent);
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		logger.info("findClass with name {}",name);
		/*
		1.Найти сам файл
		2.Подгрузить
		 */
		return null;//getParent().findClass(name);
	}
}
