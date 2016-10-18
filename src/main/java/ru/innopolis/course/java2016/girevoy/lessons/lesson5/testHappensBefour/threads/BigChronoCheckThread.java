package ru.innopolis.course.java2016.girevoy.lessons.lesson5.testHappensBefour.threads;

import ru.innopolis.course.java2016.girevoy.lessons.lesson5.testHappensBefour.items.Box;

/**
 * Created by masterlomaster on 07.10.16.
 */
public class BigChronoCheckThread extends  Thread{
	private Box counter;
	private int prevCounter;
	private int quant;

	public BigChronoCheckThread(Box counter, int quant) {
		this.counter = counter;
		this.quant = quant;
	}

	public void run() {
		while (!isInterrupted()) {
			synchronized (counter) {
				synchronized (counter) {
					try {
						do {
							counter.wait();
						} while (counter.getCounter() == prevCounter);
						prevCounter = counter.getCounter();
						if (counter.getCounter() % quant == 0){
							System.out.println("Прошло " + quant + " секунд");
						}
					} catch (InterruptedException e) {

					}
				}
			}
		}
	}
}
