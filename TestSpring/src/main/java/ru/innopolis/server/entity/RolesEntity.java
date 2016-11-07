package ru.innopolis.server.entity;

import javax.persistence.*;

/**
 * Created by Girevoy.T on 07.11.2016.
 */
@Entity
@Table(name = "roles", schema = "dbo", catalog = "TestBase")
public class RolesEntity {
	private int id;
	private String roleName;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "role_name", nullable = false, length = 50)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		RolesEntity that = (RolesEntity) o;

		if (id != that.id) return false;
		if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
		return result;
	}
}
