package ru.innopolis.course.java2016.girevoy.lessons.lesson6.testReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by masterlomaster on 10.10.16.
 */

public class Main {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		Class<TypeForTest> clazz = TypeForTest.class;

		System.out.println(clazz.getAnnotations().length);

		for (Constructor<?> constructor : clazz.getConstructors()) {
			System.out.println("constructor " + constructor.getName());
			constructor.setAccessible(false);
		}

		Field[] fields = clazz.getDeclaredFields();

		TypeForTest typeForTest = clazz.newInstance();

		for (Field field : fields) {
			field.setAccessible(true);
			field.set(typeForTest,10);
			System.out.println(field.getName() + " value " + field.get(typeForTest) + " annotations " + field.getAnnotations().length);
		}
	}
}
