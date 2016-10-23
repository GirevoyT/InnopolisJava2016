package ru.innopolis.course.java2016.girevoy.lessons.lesson14.testCollable;

import java.util.concurrent.Callable;

/**
 * Created by masterlomaster on 20.10.16.
 */
public class MyThread implements Callable<Boolean>{
	@Override
	public Boolean call() throws Exception {
		return true;
	}
}
