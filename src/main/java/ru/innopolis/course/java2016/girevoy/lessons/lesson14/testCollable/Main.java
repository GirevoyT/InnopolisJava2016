package ru.innopolis.course.java2016.girevoy.lessons.lesson14.testCollable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by masterlomaster on 20.10.16.
 */
public class Main {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<Boolean> future = executorService.submit(new MyThread());
		System.out.println(future.get().toString());
	}
}
