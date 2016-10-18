package ru.innopolis.course.java2016.girevoy.lessons.lesson3.testAll;

import ru.innopolis.course.java2016.girevoy.lessons.lesson3.testAll.entity.Car;
import ru.innopolis.course.java2016.girevoy.lessons.lesson3.testAll.entity.Order;

import java.util.*;

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
		Car vesta1 = new Car("Lada Vesta1"), vesta2 = new Car("Lada Vesta2"),vesta3 = new Car("Lada Vesta3");
		main.carSet.add(vesta1);
		main.carSet.add(vesta2);
		main.carSet.add(vesta3);

		Iterator<Car> carIterator = main.carSet.iterator();
		while (carIterator.hasNext()) {
			System.out.println(carIterator.next().getModel());
		}
		for (Car car:main.carSet){
			System.out.println(car.getModel());
		}
		System.out.println("Success");
	}
}
