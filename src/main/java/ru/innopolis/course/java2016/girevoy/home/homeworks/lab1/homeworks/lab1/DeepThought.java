package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1;

import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1.logica.Logica;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Arxan on 08.10.2016.
 */
public class DeepThought<T> {
	private Queue<T> queue = new PriorityQueue<>();
	private Logica<T> logica;
	private final DeepThought thisDeepThought = this;


	public DeepThought(Logica<T> logica) {
		this.logica = logica;
		new Thread() {
			public void run () {
				while(!isInterrupted()) {
					try {
						T tmpT = null;
						while (true) {
							synchronized (thisDeepThought) {
								synchronized (queue) {
									if (!queue.isEmpty()) {
										tmpT = queue.poll();
										break;
									}
								}
								thisDeepThought.wait();
							}
						}
						logica.logica(tmpT);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	public void addData(T data) {
		synchronized (queue) {
			queue.add((T)data);
		}
	}

}
