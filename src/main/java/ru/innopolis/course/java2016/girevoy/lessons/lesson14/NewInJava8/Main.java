package ru.innopolis.course.java2016.girevoy.lessons.lesson14.NewInJava8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by masterlomaster on 20.10.16.
 */
public class Main {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (String name : names) {
			System.out.println(name);
		}

	}
}
