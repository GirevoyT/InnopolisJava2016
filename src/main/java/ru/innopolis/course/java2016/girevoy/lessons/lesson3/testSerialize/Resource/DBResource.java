package ru.innopolis.course.java2016.girevoy.lessons.lesson3.testSerialize.Resource;

/**
 * Created by masterlomaster on 05.10.16.
 */
public class DBResource implements AutoCloseable{
	@Override
	public void close() throws Exception {
		System.out.println("Closing DB resource");
		throw  new RuntimeException("Net");
	}
}
