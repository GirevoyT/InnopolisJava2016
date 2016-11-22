package ru.innopolis.adressbook.common.models.contact;

import lombok.Getter;
import lombok.Setter;

public class Contact {
	@Getter
	@Setter
	private int version;
	@Getter
	@Setter
	private long id;
	@Getter
	@Setter
	private String firstname;
	@Getter
	@Setter
	private String lastname;
	@Getter
	@Setter
	private String middlename;
	@Getter
	@Setter
	private long phoneNumber;
	@Getter
	@Setter
	private CountryCode countryCode;
	@Getter
	@Setter
	private Adress adress;
}
