package ru.innopolis.course.java2016.girevoy.lessons.lesson14.newInJava8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by masterlomaster on 20.10.16.
 */
public class Main {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Test test = new Test();
//		names.sort((o1,o2) ->  {return o1.compareTo(o2);});
		names.sort(test::doSome);

//		for (String name : names) {
//			System.out.println(name);
//		}
		names.forEach((a) -> System.out.println(a));
//		names.removeIf((a) -> "anna".equals(a));
//		names.forEach((a) -> System.out.println(a));
	}
}
