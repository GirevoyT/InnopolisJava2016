package ru.innopolis.course.java2016.girevoy.lessons.lesson4.testMultithread;

/**
 * Created by masterlomaster on 06.10.16.
 */
public class MyThreadExtends extends Thread {
	private final String name;
	private Box counter;

	public MyThreadExtends(String name, Box counter) {
		this.name = name;
		this.counter = counter;
		//setDaemon(true);
	}

	@Override
	public void run() {

		synchronized (this.counter) {
			try {
				this.counter.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread: \""  +this.name + "\" successfully!");
	}
}
