package ru.innopolis.course.java2016.girevoy.lessons.lesson4.testMultithread;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by masterlomaster on 06.10.16.
 */
public class TestMultithread {
	public static void main(String[] args) {
		Set<Thread> threadSet = new HashSet<>();
		Box box = new Box(0);

		Thread t1 = new MyThreadExtends("Thread 1",box);
		Thread t2 = new MyThreadExtends("Thread 2",box);
		Thread t3 = new MyThreadExtends("Thread 3",box);

		threadSet.add(t1);
		threadSet.add(t2);
		threadSet.add(t3);


		for (Thread thread : threadSet) {
			thread.start();
		}

		t1.interrupt();
		synchronized (box) {
			box.notifyAll();
		}
	}
}
