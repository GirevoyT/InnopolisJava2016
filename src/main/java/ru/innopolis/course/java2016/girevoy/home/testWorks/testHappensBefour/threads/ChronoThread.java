package ru.innopolis.course.java2016.girevoy.home.testWorks.testHappensBefour.threads;

/**
 * Created by masterlomaster on 07.10.16.
 */
public class ChronoThread extends Thread {
	private int time;

	public ChronoThread(int startTime) {
		this.time = startTime;
		this.setDaemon(true);
	}

	public int getTime() {				//WARNING! Узнать насколько красиво с точки зрения кода обращаться к класу потока для выполнения метода!
		synchronized (this) {
			return this.time;
		}
	}

	public void run() {
		while (!isInterrupted()) {
			try {
				Thread.sleep(1000);
				synchronized (this) {
					time++;
					System.out.println("Прошла секунда " + time);
					this.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
