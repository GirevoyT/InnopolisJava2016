package ru.innopolis.adressbook.common.models.contact;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Girevoy.T on 21.11.2016.
 */
public class CountryCode {
	@Getter
	@Setter
	private int version;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String code;
}
