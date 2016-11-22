package ru.innopolis.adressbook.server.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

public class AdressEntity {

	@Getter
	@Setter
	@Version
	private int version;

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false,insertable = false,updatable = false)
	private int id;

	@Getter
	@Setter
	@Basic
	@Column(name = "counrty", nullable = false, length = 50)
	private String counrty;
	@Getter
	@Setter
	private String sity;
	@Getter
	@Setter
	private String street;
	@Getter
	@Setter
	private int building;
	@Getter
	@Setter
	private int corpus;
	@Getter
	@Setter
	private int flat;
}
