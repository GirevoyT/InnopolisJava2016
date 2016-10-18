package ru.innopolis.course.java2016.girevoy.lessons.lesson3.testSerialize.entity;

/**
 * Created by masterlomaster on 05.10.16.
 */
public final class Customer {
	private final String firstname;
	private final String lastname;
	private final int age;

	/**
	 *
	 * @param firstname
	 * @param lastname
	 * @param age
	 */
	public Customer(String firstname, String lastname, int age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	/**
	 *
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 *
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 *
	 * @return
	 */
	public int getAge() {
		return age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Customer customer = (Customer) o;

		if (age != customer.age) return false;
		if (firstname != null ? !firstname.equals(customer.firstname) : customer.firstname != null) return false;
		return lastname != null ? lastname.equals(customer.lastname) : customer.lastname == null;

	}

	@Override
	public int hashCode() {
		int result = firstname != null ? firstname.hashCode() : 0;
		result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
		result = 31 * result + age;
		return result;
	}
}
