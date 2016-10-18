package ru.innopolis.course.java2016.girevoy.lessons.lesson3.testSerialize;

import ru.innopolis.course.java2016.girevoy.lessons.lesson3.testSerialize.entity.Car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by masterlomaster on 05.10.16.
 */
public class Main {
	public static void main(String[] args) {
		try (
				FileOutputStream fileOutputStream = new FileOutputStream("./Cars");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				FileInputStream fileInputStream = new FileInputStream("./Cars2");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);)
		{
			Car vesta1 = new Car("Lada Vesta");
			vesta1.setRegnum("asdasdasdasd");
			objectOutputStream.writeObject(vesta1);
			Car vesta2 = (Car)objectInputStream.readObject();
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
