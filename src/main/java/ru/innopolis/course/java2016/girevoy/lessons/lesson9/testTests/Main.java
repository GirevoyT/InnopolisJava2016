package ru.innopolis.course.java2016.girevoy.lessons.lesson9.testTests;

/**
 * Created by masterlomaster on 13.10.16.
 */
public class Main {
	private static final  String HELLO_WORLD = "HelloWorld";
	public static void main(String[] args) {

	}
	public boolean isHelloWorld (String arg) {
		boolean result = false;
		if (arg != null) {
			result = arg.toLowerCase().equals(HELLO_WORLD.toLowerCase());
		}
		return result;
	}
	public boolean isString (Object arg) {
		boolean result = false;
		if (arg != null) {
			result = String.class.equals(arg.getClass());
		}
		return result;
	}
}
