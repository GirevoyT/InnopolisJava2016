package ru.innopolis.course.java2016.girevoy.lessons.lesson14.NewInJava8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by masterlomaster on 20.10.16.
 */
public class Main {
	public static void main(String[] args) {
		int value = 4;
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		names.sort((o1,o2) ->  {return o1.compareTo(o2);});
		for (String name : names) {
			System.out.println(name);
		}

	}
}
