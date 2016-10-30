package ru.innopolis.course.java2016.girevoy.home.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Arxan on 30.10.2016.
 */
public class SecurityConfig {
	public static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	public static final String USER_PASSWORD_CRYPT_KEY;
	static {
		USER_PASSWORD_CRYPT_KEY = "TEST";
	}
}
