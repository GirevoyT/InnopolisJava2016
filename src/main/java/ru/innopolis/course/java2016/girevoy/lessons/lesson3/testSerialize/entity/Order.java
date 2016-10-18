package ru.innopolis.course.java2016.girevoy.lessons.lesson3.testSerialize.entity;

/**
 * Created by masterlomaster on 05.10.16.
 */
public final class Order {
	private final Customer customer;

	/**
	 *
	 * @param customer
	 */
	public Order(Customer customer) {
		this.customer = customer;
	}

	/**
	 * This method ..
	 * @return customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;

		return customer != null ? customer.equals(order.customer) : order.customer == null;

	}

	@Override
	public int hashCode() {
		return customer != null ? customer.hashCode() : 0;
	}
}
