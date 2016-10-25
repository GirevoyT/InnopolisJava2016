package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testPattern2;

/**
 * Created by oem on 25.10.16.
 */
public class Stanok {
	private Replicateble prototype;

	public void setPrototype(Replicateble prototype) {
		this.prototype = prototype;
	}

	public Object getCopy() throws CloneNotSupportedException {
		return prototype.clone();
	}
}
