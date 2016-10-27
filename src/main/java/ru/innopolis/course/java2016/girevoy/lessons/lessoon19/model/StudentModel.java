package ru.innopolis.course.java2016.girevoy.lessons.lessoon19.model;

/**
 * Created by Girevoy.T on 27.10.2016.
 */
public class StudentModel {
	private final String firstname;
	private final String lastname;
	private final PassportModel passport;

	public StudentModel(String firstname, String lastname, PassportModel passport) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.passport = passport;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public PassportModel getPassport() {
		return passport;
	}
}
