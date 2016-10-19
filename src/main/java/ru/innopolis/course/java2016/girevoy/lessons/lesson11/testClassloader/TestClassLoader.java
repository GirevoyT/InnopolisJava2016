package ru.innopolis.course.java2016.girevoy.lessons.lesson11.testClassloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.lessons.lesson11.testClassloader.classloader.LoggableClassLoader;

/**
 * Created by masterlomaster on 17.10.16.
 */
public class TestClassLoader {
	private static Logger logger = LoggerFactory.getLogger(TestClassLoader.class);
	public static void main(String[] args) {
		SecurityManager sm = System.getSecurityManager();

		LoggableClassLoader classLoader = new LoggableClassLoader(getClassLoader());
		try {
			Class test = classLoader.loadClass("tmp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ClassLoader getClassLoader() {
		return TestClassLoader.class.getClassLoader();
	}
}
