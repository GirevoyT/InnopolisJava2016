package ru.innopolis.course.java2016.girevoy.lessons.lesson7.testConsole;

import java.util.Scanner;

/**
 * Created by masterlomaster on 11.10.16.
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread() {
			@Override
			public void run() {

				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("qweqwe");
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
		Thread.sleep(1000);
		Thread qwe = Thread.currentThread();
		qwe.interrupt();

	}
}
