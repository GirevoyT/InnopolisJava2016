package ru.innopolis.course.java2016.girevoy.lessons.lesson14.test.threads;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * Created by masterlomaster on 10.10.16.
 */
public class BigThread implements Callable<Boolean>{
	private Set<Integer> set = new HashSet<>();

	/**
	 * Метод для добавления значения в хранилище (уникальность обеспеценна HashSet)
	 * @param tmpValue
	 */
	public synchronized void addValue(int tmpValue) {
		set.add(new Integer(tmpValue));
		System.out.println("Сгенерированно значение " + tmpValue);
	}

	public Boolean call() throws IOException {
//		throw new IOException();
		while (!Thread.currentThread().isInterrupted()) {
			try {

				Thread.sleep(5000);
				synchronized (this) {
					System.out.println("Колличество уникальных значений " + set.size());
					if (set.size() == 101) {
						System.out.println("Программа завершает работу");
						Thread.currentThread().interrupt();
						return true;
					}
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return false;
	}



}
