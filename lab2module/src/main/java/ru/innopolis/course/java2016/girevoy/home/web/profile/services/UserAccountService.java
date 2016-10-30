package ru.innopolis.course.java2016.girevoy.home.web.profile.services;

import ru.innopolis.course.java2016.girevoy.home.database.exeptions.AddConectionToPoolExeption;
import ru.innopolis.course.java2016.girevoy.home.database.exeptions.NoFreeConnectionExeption;
import ru.innopolis.course.java2016.girevoy.home.database.services.ConnectionsPoolService;
import ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions.CreateUserExeption;
import ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions.FindUserInDBExeption;
import ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions.WriteUserToDBExeption;
import ru.innopolis.course.java2016.girevoy.home.web.profile.models.UserAccount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * @return возвращает экземпляр класса UserAccount
	 * @throws CreateUserExeption ошибка создания пользовательского аккаунта
	 */
	public static UserAccount createUserAccount (String email,String password, String firstname, String secondname, String middlename) throws CreateUserExeption {
		if (email == null || password == null || firstname == null || secondname == null || middlename == null ) {
			throw new CreateUserExeption("Одно из передаваемых полей при создании нового аккаунта пользователя null");
		}
		return new UserAccount(email,password,firstname,secondname,middlename);
	}

	/**
	 * Метод по зоданию нового аккаунта пользователя с переданными параметрами (без отчества)
	 * @param email почтовый адрес пользователя
	 * @param password пароль пользователя
	 * @param firstname имя пользователя
	 * @param secondname фамилия пользователя
	 * @return возвращает экземпляр класса UserAccount
	 * @throws CreateUserExeption ошибка создания пользовательского аккаунта
	 */
	public static UserAccount createUserAccount (String email,String password, String firstname, String secondname) throws CreateUserExeption {
		if (email == null || password == null || firstname == null || secondname == null) {
			throw new CreateUserExeption("Одно из передаваемых полей при создании нового аккаунта пользователя null");
		}
		return new UserAccount(email,password,firstname,secondname,null);
	}

	/**
	 * Метод по записи нового юзера в БД
	 * @param userAccount Аккаунт юзера
	 * @throws WriteUserToDBExeption Ошибка записи юзера в БД
	 */
	public static void writeNewUserToDatabase (UserAccount userAccount) throws WriteUserToDBExeption {
		Connection connection = null;
		try {
			connection = ConnectionsPoolService.getConnectionWithWait();
			Statement statement = connection.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO users(email,encrypted_password,firstname,lastname,middlename,reg_date) ")
					.append("VALUES ('").append(userAccount.getEmail()).append("','")
					.append(userAccount.getEncryptedPassword()).append("','")
					.append(userAccount.getFirstname()).append("','")
					.append(userAccount.getLastname()).append("','")
					.append(userAccount.getMiddlename()).append("',") //WARNING!!! Обработать отчество null
					.append("GETDATE())\n");
			statement.executeUpdate(sql.toString());
		} catch (AddConectionToPoolExeption e) {
			throw new WriteUserToDBExeption(e);
		} catch (SQLException e) {
			throw new WriteUserToDBExeption(e);
		} catch (NoFreeConnectionExeption e) {
			throw new WriteUserToDBExeption(e);
		} finally {
			if (connection != null) {
				ConnectionsPoolService.returnConnection(connection);
			}
		}
	}
	/**
	 * Метод по исправлению записи юзера в БД (если указан oldEmail то будет переписана запись с ним)
	 * в противном случае будет переписанна запись с нынешним email
	 * @param userAccount Аккаунт юзера
	 * @throws WriteUserToDBExeption Ошибка записи юзера в БД
	 */
	public static void changeUserInDatabase (UserAccount userAccount) throws WriteUserToDBExeption {
		Connection connection = null;
		try {
			connection = ConnectionsPoolService.getConnectionWithWait();
			Statement statement = connection.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE users SET email='").append(userAccount.getEmail())
					.append("',encrypted_password='").append(userAccount.getEncryptedPassword())
					.append("',firstname='").append(userAccount.getFirstname())
					.append("',lastname='").append(userAccount.getLastname())
					.append("',middlename='").append(userAccount.getMiddlename()) //WARNING!!! Обработать отчество null
					.append("',change_date=GETDATE() ")
					.append("WHERE email='")
						.append(userAccount.getOldEmail() != null ? userAccount.getOldEmail() : userAccount.getEmail())
					.append("'\n");
			statement.executeUpdate(sql.toString());
		} catch (AddConectionToPoolExeption e) {
			throw new WriteUserToDBExeption(e);
		} catch (SQLException e) {
			throw new WriteUserToDBExeption(e);
		} catch (NoFreeConnectionExeption e) {
			throw new WriteUserToDBExeption(e);
		} finally {
			if (connection != null) {
				ConnectionsPoolService.returnConnection(connection);
			}
		}
	}

	/**
	 * Метод который забирает пользователя из бд по email
	 * @param email email пользователя
	 * @return возвращает UserAccount пользователя с данным email
	 * @throws FindUserInDBExeption ошибка контейнер или если такого пользователя нет
	 */
	public static UserAccount getUserFromDatabase (String email) throws FindUserInDBExeption {
		Connection connection = null;
		try {
			connection = ConnectionsPoolService.getConnectionWithWait();
			Statement statement = connection.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("Select * FROM users WHERE email='").append(email).append("'");
			ResultSet resultSet = statement.executeQuery(sql.toString());
			if (resultSet.next()) {
				UserAccount result = new UserAccount();
				result.setFirstname(resultSet.getString("firstname"));
				result.setLastname(resultSet.getString("lastname"));
				result.setMiddlename(resultSet.getString("middlename"));
				result.setEmail(resultSet.getString("email"));
				result.setEncryptedPassword(resultSet.getString("encrypted_password"));
				return result;
			} else {
				throw new FindUserInDBExeption("Пользователя с таким email не существует");
			}
		} catch (AddConectionToPoolExeption e) {
			throw new FindUserInDBExeption(e);
		} catch (SQLException e) {
			throw new FindUserInDBExeption(e);
		} catch (NoFreeConnectionExeption e) {
			throw new FindUserInDBExeption(e);
		} finally {
			if (connection != null) {
				ConnectionsPoolService.returnConnection(connection);
			}
		}
	}
}
