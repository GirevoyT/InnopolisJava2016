package ru.innopolis.course.java2016.girevoy.lessons.lesson3.testSet;

import ru.innopolis.course.java2016.girevoy.lessons.lesson3.testSerialize.entity.Car;
import ru.innopolis.course.java2016.girevoy.lessons.lesson3.testSerialize.entity.Order;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by masterlomaster on 05.10.16.
 */
public class Main {
	private Map<Order, Car> orderRegistry = createRegisty();
	private Set<Car> carSet = createCarSet();

	private Set<Car> createCarSet() {
		return new HashSet<>();
	}

	private Map<Order,Car> createRegisty() {
		return new HashMap<>();
	}

	public static void main (String[] args) {
		Main main= new Main();
		Car vesta1 = new Car("Lada Vesta"), vesta2 = new Car("Lada Vesta"),vesta3 = new Car("Lada Vesta");
		main.carSet.add(vesta1);
		main.carSet.add(vesta2);
		main.carSet.add(vesta3);

		System.out.println("Success");
	}
}
