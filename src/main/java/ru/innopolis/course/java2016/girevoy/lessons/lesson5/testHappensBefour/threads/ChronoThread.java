package ru.innopolis.course.java2016.girevoy.lessons.lesson5.testHappensBefour.threads;

import ru.innopolis.course.java2016.girevoy.lessons.lesson5.testHappensBefour.items.Box;

/**
 * Created by masterlomaster on 07.10.16.
 */
public class ChronoThread extends Thread {
	private long tmpTime;
	private Box counter;

	public ChronoThread(Box counter) {
		this.counter = counter;
	}

	public void run() {
		while (!isInterrupted()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (counter) {
				counter.setCounter(counter.getCounter() + 1);
				System.out.println("Прошла секунда " + counter.getCounter());
				counter.notifyAll();
				counter.setMarker(true);
			}
		}
	}
}
