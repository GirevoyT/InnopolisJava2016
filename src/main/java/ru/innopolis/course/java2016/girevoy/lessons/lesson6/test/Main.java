package ru.innopolis.course.java2016.girevoy.lessons.lesson6.test;

import ru.innopolis.course.java2016.girevoy.lessons.lesson6.test.threads.BigThread;
import ru.innopolis.course.java2016.girevoy.lessons.lesson6.test.threads.SmallThread;

/**
 * Created by masterlomaster on 10.10.16.
 */
public class Main {
	public static void main(String[] args) {
		BigThread bigThread = new BigThread();
		SmallThread smallThread = new SmallThread(bigThread);
	}
}
