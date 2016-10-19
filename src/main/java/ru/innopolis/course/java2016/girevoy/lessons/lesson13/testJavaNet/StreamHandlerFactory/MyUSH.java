package ru.innopolis.course.java2016.girevoy.lessons.lesson13.testJavaNet.StreamHandlerFactory;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * Created by masterlomaster on 19.10.16.
 */
public class MyUSH extends URLStreamHandler {
	@Override
	protected URLConnection openConnection(URL url) throws IOException {
		return null;
	}
}
