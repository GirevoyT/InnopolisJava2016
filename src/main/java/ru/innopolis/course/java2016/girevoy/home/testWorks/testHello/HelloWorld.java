package ru.innopolis.course.java2016.girevoy.home.testWorks.testHello;

/**
 * Created by Arxan on 05.10.2016.
 */
public class HelloWorld {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("123");
			}
		}.start();
		Integer tmp  = 5;
		synchronized (tmp) {
			tmp.notify();
		}
	}
}
