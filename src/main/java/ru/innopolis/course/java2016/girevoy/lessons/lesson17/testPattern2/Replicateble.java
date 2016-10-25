package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testPattern2;

/**
 * Created by oem on 25.10.16.
 */
public interface Replicateble extends Cloneable {
	public Object clone() throws CloneNotSupportedException;
}
