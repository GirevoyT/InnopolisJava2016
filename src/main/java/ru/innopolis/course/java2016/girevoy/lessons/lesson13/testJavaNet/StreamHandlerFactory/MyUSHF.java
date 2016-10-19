package ru.innopolis.course.java2016.girevoy.lessons.lesson13.testJavaNet.StreamHandlerFactory;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
/**
 * Created by masterlomaster on 19.10.16.
 */
public class MyUSHF implements URLStreamHandlerFactory {
	public URLStreamHandler createURLStreamHandler(String protocol) {
		if ( protocol.equalsIgnoreCase("classpath") )
			return new MyUSH();
		else
			return null;
	}
}
