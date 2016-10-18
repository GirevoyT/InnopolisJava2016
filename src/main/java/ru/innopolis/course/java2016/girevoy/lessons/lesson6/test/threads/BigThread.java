package ru.innopolis.course.java2016.girevoy.lessons.lesson6.test.threads;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by masterlomaster on 10.10.16.
 */
public class BigThread extends Thread{
	private Set<Integer> set = new HashSet<>();

	/**
	 * Метод для добавления значения в хранилище (уникальность обеспеценна HashSet)
	 * @param tmpValue
	 */
	public synchronized void addValue(int tmpValue) {
		set.add(new Integer(tmpValue));
		System.out.println("Сгенерированно значение " + tmpValue);
	}


	/**
	 * Конструктор просто запускает поток при создании
	 */
	public BigThread() {
		this.start();
	}


	/**
	 * Просто ран :)
	 * Раз в 5 секунд проверяет колличество эллементов в сете
	 * При достижении 101 (от 0 до 100) останавливает поток
	 *
	 */
	public void run() {
		while (!isInterrupted()) {
			try {
				Thread.sleep(5000);
				synchronized (this) {
					System.out.println("Колличество уникальных значений " + set.size());
					if (set.size() == 101) {
						System.out.println("Программа завершает работу");
						this.interrupt();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
