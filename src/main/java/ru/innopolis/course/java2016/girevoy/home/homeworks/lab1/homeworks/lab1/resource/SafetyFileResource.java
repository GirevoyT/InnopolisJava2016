package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Arxan on 08.10.2016.
 */
public class SafetyFileResource extends Resource<Integer> {

	private final Queue<Integer> queue = new PriorityQueue<>();

	/**
	 * Конструктор который открывает файл fileName и заполняет очередь всеми int из него
	 * @param fileName
	 */
	public SafetyFileResource(String fileName) {
		new Thread(){						//WARNING! Как ведут себя анонимные классы со сборщиком мусора
			@Override
			public void run() {
				try (FileInputStream fileInputStream = new FileInputStream(fileName);
					 Scanner scanner = new Scanner(fileInputStream);) {
					while (scanner.hasNextInt()) {
						Integer tmpInt = scanner.nextInt();
						synchronized (queue) {
							queue.add(tmpInt);			//WARNING! Где красивше проверять на чётность и положительность! (или вообще считавать всё а уже потом проверять ещё и на то что это int
						}
						synchronized (SafetyFileResource.this) {
							if (getCountOfListeners() > 0) {
								SafetyFileResource.this.notify();
								takeTheListener();
							}
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					compliteResource();
					synchronized (SafetyFileResource.this) {
						if (getCountOfListeners() > 0) {
							SafetyFileResource.this.notifyAll();
						}
					}
				}
			}
		}.start();
	}

	@Override
	/**
	 * Просто проверяем пуста ли очередь
	 */
	public boolean hasNext() {
		synchronized (queue) {          //WARNING! Поподробней про синхронайз. 1. Синхронайз объекта и его поля и их взаимодействие 2. Какую память переносит синхронайз (зависит или нет от монитора)
			return !queue.isEmpty();
		}
	}

	@Override
	/**
	 * Просто возвращаем следующий объект из очереди
	 */
	public Integer next() {
		synchronized (queue) {
			return queue.poll();
		}
	}
}
