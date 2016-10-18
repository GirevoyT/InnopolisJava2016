package ru.innopolis.course.java2016.girevoy.lessons.lesson5.testHappensBefour.items;

/**
 * Created by masterlomaster on 07.10.16.
 */
public class Box {
	private int counter;
	private boolean marker;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Box(int counter) {
		this.counter = counter;
	}

	public boolean isMarker() {
		return marker;
	}

	public void setMarker(boolean marker) {
		this.marker = marker;
	}
}
