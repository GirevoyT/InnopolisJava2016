package ru.innopolis.server.dao.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Arxan on 07.11.2016.
 */
@Entity
@Table(name = "Students", schema = "dbo", catalog = "TestBase")
public class StudentsEntity {
	private int id;
	private String firstname;
	private String lastname;
	private boolean sex;
	private Date birthDate;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "firstname", nullable = false, length = 50)
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Basic
	@Column(name = "lastname", nullable = false, length = 50)
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Basic
	@Column(name = "sex", nullable = false)
	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Basic
	@Column(name = "birth_date", nullable = false)
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		StudentsEntity that = (StudentsEntity) o;

		if (id != that.id) return false;
		if (sex != that.sex) return false;
		if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
		if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
		if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
		result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
		result = 31 * result + (sex ? 1 : 0);
		result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
		return result;
	}
}
