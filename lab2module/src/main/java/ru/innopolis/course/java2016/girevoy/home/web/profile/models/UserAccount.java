package ru.innopolis.course.java2016.girevoy.home.web.profile.models;

import java.util.Date;

/**
 * Created by Arxan on 28.10.2016.
 */
public class UserAccount {
	private String email;
	private String password;
	private String firstname;
	private String secondname;
	private String middlename;
	private Date registrationDate;

	public UserAccount(String email,String password, String firstname, String secondname, String middlename, Date registrationDate) {
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.secondname = secondname;
		this.middlename = middlename;
		this.registrationDate = registrationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
}
