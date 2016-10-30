package ru.innopolis.course.java2016.girevoy.home.web.profile.models;

import ru.innopolis.course.java2016.girevoy.home.config.SecurityConfig;
import ru.innopolis.course.java2016.girevoy.home.security.crypt.AesCrypt;

/**
 * Created by Arxan on 28.10.2016.
 */
public class UserAccount {
	private String email;
	private String password;
	private String encryptedPassword;
	private String firstname;
	private String lastname;
	private String middlename;
	private String oldEmail;

	public UserAccount () {};

	public UserAccount(String email,String password, String firstname, String lastname, String middlename) {
		setEmail(email);
		setPassword(password);
		setFirstname(firstname);
		setLastname(lastname);
		setMiddlename(middlename);
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		AesCrypt aesCrypt = new AesCrypt(SecurityConfig.USER_PASSWORD_CRYPT_KEY);
		this.encryptedPassword = aesCrypt.encrypt(password);
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
		AesCrypt aesCrypt = new AesCrypt(SecurityConfig.USER_PASSWORD_CRYPT_KEY);
		this.password = aesCrypt.decrypt(encryptedPassword);
	}

	public String getOldEmail() {
		return oldEmail;
	}

	public void setOldEmail(String oldEmail) {
		this.oldEmail = oldEmail;
	}
}
