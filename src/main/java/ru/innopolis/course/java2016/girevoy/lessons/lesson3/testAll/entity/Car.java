package ru.innopolis.course.java2016.girevoy.lessons.lesson3.testAll.entity;

/**
 * Created by masterlomaster on 05.10.16.
 */
public class Car {

	private String model;

	/**
	 *
	 * @param model
	 */
	public Car(String model) {
		this.model = model;
	}

	/**
	 * This method ...
	 * @return model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * This method set model
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Car car = (Car) o;

		return model.equals(car.model);

	}

	@Override
	public int hashCode() {
		return model.hashCode();
	}
}
