package ru.innopolis.course.java2016.girevoy.lessons.lesson3.testResource.Resource;

/**
 * Created by masterlomaster on 05.10.16.
 */
public class NetResource implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("Closing Net resource");
		throw  new RuntimeException("Net");
	}
}
