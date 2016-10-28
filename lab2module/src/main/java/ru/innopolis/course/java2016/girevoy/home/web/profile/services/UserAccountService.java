package ru.innopolis.course.java2016.girevoy.home.web.profile.services;

import ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions.CreateUserExeption;
import ru.innopolis.course.java2016.girevoy.home.web.profile.models.UserAccount;

import java.util.Date;

/**
 * Created by Arxan on 28.10.2016.
 */
public class UserAccountService {
	/**
	 * Метод по зоданию нового аккаунта пользователя с переданными параметрами (с отчеством)
	 * @param email почтовый адрес пользователя
	 * @param password пароль пользователя
	 * @param firstname имя пользователя
	 * @param secondname фамилия пользователя
	 * @param middlename отчество пользователя
	 * @param registrationDate дата регистрации
	 * @return возвращает экземпляр класса UserAccount
	 * @throws CreateUserExeption ошибка создания пользовательского аккаунта
	 */
	public UserAccount createUserAccount (String email,String password, String firstname, String secondname, String middlename, Date registrationDate) throws CreateUserExeption {
		if (email == null || password == null || firstname == null || secondname == null || middlename == null || registrationDate == null) {
			throw new CreateUserExeption("Одно из передаваемых полей при создании нового аккаунта пользователя null");
		}
		return new UserAccount(email,password,firstname,secondname,middlename,registrationDate);
	}

	/**
	 * Метод по зоданию нового аккаунта пользователя с переданными параметрами (без отчества)
	 * @param email почтовый адрес пользователя
	 * @param password пароль пользователя
	 * @param firstname имя пользователя
	 * @param secondname фамилия пользователя
	 * @param registrationDate дата регистрации
	 * @return возвращает экземпляр класса UserAccount
	 * @throws CreateUserExeption ошибка создания пользовательского аккаунта
	 */
	public UserAccount createUserAccount (String email,String password, String firstname, String secondname, Date registrationDate) throws CreateUserExeption {
		if (email == null || password == null || firstname == null || secondname == null || registrationDate == null) {
			throw new CreateUserExeption("Одно из передаваемых полей при создании нового аккаунта пользователя null");
		}
		return new UserAccount(email,password,firstname,secondname,null,registrationDate);
	}
}
