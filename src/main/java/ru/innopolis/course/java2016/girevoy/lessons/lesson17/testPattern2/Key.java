package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testPattern2;

/**
 * Created by oem on 25.10.16.
 */
public class Key implements Replicateble{
	private int keySize;
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	public int getKeySize() {
		return keySize;
	}

	public void setKeySize(int keySize) {
		this.keySize = keySize;
	}
}
