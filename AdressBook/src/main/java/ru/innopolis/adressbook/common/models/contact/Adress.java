package ru.innopolis.adressbook.common.models.contact;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Girevoy.T on 21.11.2016.
 */
public class Adress {
	@Getter
	@Setter
	private int version;
	@Getter
	@Setter
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
