package ru.innopolis.course.java2016.girevoy.lessons.lesson4.testMultithread;

/**
 * Created by masterlomaster on 06.10.16.
 */
public class DeadLock {
	public static void main(String[] args) {
		Object monitor1 = new Object();
		Object monitor2 = new Object();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("First thread started");
				synchronized (monitor1) {
					System.out.println("First thread lock monitor1");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (monitor2) {
						System.out.println("First thread lock monitor2");
					}
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Second thread started");
				synchronized (monitor2) {
					System.out.println("First thread lock monitor2");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (monitor1) {
						System.out.println("First thread lock monitor1");
					}
				}

			}
		});
		t1.start();
		t2.start();
	}
}
