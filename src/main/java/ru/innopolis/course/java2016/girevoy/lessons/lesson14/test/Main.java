package ru.innopolis.course.java2016.girevoy.lessons.lesson14.test;

import ru.innopolis.course.java2016.girevoy.lessons.lesson14.test.threads.BigThread;
import ru.innopolis.course.java2016.girevoy.lessons.lesson14.test.threads.SmallThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by masterlomaster on 10.10.16.
 */
public class Main {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		BigThread bigThread = new BigThread();
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<Boolean> future = executorService.submit(bigThread);
		SmallThread smallThread = new SmallThread(bigThread);
		smallThread.start();
		Thread.sleep(100);
		System.out.println(future.get());
		executorService.shutdown();
		System.out.println();
	}
}
