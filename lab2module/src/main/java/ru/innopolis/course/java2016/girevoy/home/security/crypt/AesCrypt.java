package ru.innopolis.course.java2016.girevoy.home.security.crypt;

/**
 * Created by Arxan on 30.10.2016.
 */
public class AesCrypt implements Crypt{
	private String key;

	public AesCrypt(String key) {
		this.key = key;
	}

	public String encrypt(String string) {
		return string;
	}
	public String decrypt(String string) {
		return string;
	}

}
