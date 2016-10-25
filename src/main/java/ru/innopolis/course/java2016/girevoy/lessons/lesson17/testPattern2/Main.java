package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testPattern2;

/**
 * Created by oem on 25.10.16.
 */
public class Main {
	public static void main(String[] args) {
		Key key= new Key();
		key.setKeySize(50);

		Stanok stanok = new Stanok();
		stanok.setPrototype(key);

		Key newKey = null;
		try {
			newKey = (Key)stanok.getCopy();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		key.setKeySize(100);
		System.out.println(newKey.getKeySize());
	}
}
