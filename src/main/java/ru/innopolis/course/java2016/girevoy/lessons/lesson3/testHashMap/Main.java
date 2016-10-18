package ru.innopolis.course.java2016.girevoy.lessons.lesson3.testHashMap;

import ru.innopolis.course.java2016.girevoy.lessons.lesson3.testHashMap.entity.Car;
import ru.innopolis.course.java2016.girevoy.lessons.lesson3.testHashMap.entity.Customer;
import ru.innopolis.course.java2016.girevoy.lessons.lesson3.testHashMap.entity.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by masterlomaster on 05.10.16.
 */
public class Main {
	Map<Order, Car> orderRegistry = createRegisty();

	private Map<Order,Car> createRegisty() {
		return new HashMap<>();
	}

	public static void main (String[] args) {
		Main main= new Main();
		Customer saraConnor = new Customer("Sara","Connor",18);

		Order firstOrder = new Order(saraConnor);
		Order secondOrder = new Order(saraConnor);

		Car vesta = new Car("Lada Vesta");
		main.orderRegistry.put(firstOrder, vesta);

		System.out.println(main.orderRegistry.get(secondOrder).getModel());
	}
}
