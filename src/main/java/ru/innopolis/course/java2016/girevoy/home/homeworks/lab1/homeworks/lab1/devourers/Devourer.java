package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1.devourers;


import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1.DeepThought;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.homeworks.lab1.resource.Resource;

/**
 * Created by Arxan on 08.10.2016.
 */
public class Devourer<T> extends Thread{
	private Resource<T> resource;
	private DeepThought deepThought;

	public Devourer(Resource<T> resource, DeepThought deepThought) {
		this.resource = resource;
		this.deepThought = deepThought;
		this.start();
	}


	@Override
	public void run() {
		while (!isInterrupted()) {
			T tmpObject;
			synchronized (resource) {
				if (resource.hasNext()) {
					tmpObject = resource.next();
					synchronized (deepThought) {
						deepThought.addData(tmpObject);
						deepThought.notify();
					}
				} else if (!resource.isComplite()) {
					try {
						resource.addListener();
						resource.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						resource.takeTheListener();
					}
				} else {
					this.interrupt();
				}
			}
		}
	}
}
