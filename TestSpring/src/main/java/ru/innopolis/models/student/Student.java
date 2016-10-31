package ru.innopolis.models.student;

import java.util.Date;

/**
 * Created by Girevoy.T on 31.10.2016.
 */
public class Student {
	private String firstname;
	private String lastname;
	private Sex sex;
	private Date birthDate;

	public Student(String firstname, String lastname, Sex sex, Date birthDate) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.sex = sex;
		this.birthDate = birthDate;
	}

	public Student() {

	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
