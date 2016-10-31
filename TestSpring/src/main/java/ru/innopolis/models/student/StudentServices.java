package ru.innopolis.models.student;

import ru.innopolis.database.exeptions.AddConectionToPoolExeption;
import ru.innopolis.database.exeptions.NoFreeConnectionExeption;
import ru.innopolis.database.services.ConnectionsPoolService;
import ru.innopolis.models.student.exeptions.ReadStudentsFromDBExeption;
import ru.innopolis.models.student.exeptions.WriteStudentToDBExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

import static ru.innopolis.models.student.StudentServices.Order.firstname;

/**
 * Created by Girevoy.T on 31.10.2016.
 */
public class StudentServices {
	public static Student createNewStudentRandom() {
		Random random = new Random();
		return new Student(new Integer(random.nextInt()).toString(),
				new Integer(random.nextInt()).toString(),
				Sex.Male,
				new Date(random.nextLong()));
	}
	public static void writeNewStudentToDB (Student student) throws WriteStudentToDBExeption {
		Connection connection = null;
		try {
			connection = ConnectionsPoolService.getConnectionWithWait();
			Statement statement = connection.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO students(firstname,lastname,sex,birth_date) ")
					.append("VALUES ('").append(student.getFirstname()).append("','")
					.append(student.getLastname()).append("',")
					.append(Sex.Female.equals(student.getSex()) ? 0 : 1).append(",'")
					.append(student.getBirthDate().toString()).append("'");
			statement.executeUpdate(sql.toString());
		} catch (AddConectionToPoolExeption e) {
			throw new WriteStudentToDBExeption(e);
		} catch (SQLException e) {
			throw new WriteStudentToDBExeption(e);
		} catch (NoFreeConnectionExeption e) {
			throw new WriteStudentToDBExeption(e);
		} finally {
			if (connection != null) {
				ConnectionsPoolService.returnConnection(connection);
			}
		}
	}
	public static enum Order {firstname,lastname,birthDate}
	public Student[] getStudentsFromDB (Order order) throws ReadStudentsFromDBExeption {
		String orderString = null;
		switch (order) {
			case firstname:
				orderString = "ORDER BY firstname";
				break;
			case lastname:
				orderString = "ORDER BY lastname";
				break;
			case birthDate:
				orderString = "ORDER BY birth_date";
				break;
		}
		Student[] students = null;
		Connection connection = null;
		try {
			connection = ConnectionsPoolService.getConnectionWithWait();
			Statement statement = connection.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("Select * from Students ").append(orderString);
			ResultSet resultSet = statement.executeQuery(sql.toString());
			resultSet.last();
			students = new Student[resultSet.getRow()];
			resultSet.beforeFirst();
			int i = 0;
			while (resultSet.next()) {
				students[i] = new Student();
				students[i].setFirstname(resultSet.gets);
			}
		} catch (AddConectionToPoolExeption e) {
			throw new ReadStudentsFromDBExeption(e);
		} catch (NoFreeConnectionExeption e) {
			throw new ReadStudentsFromDBExeption(e);
		} catch (SQLException e) {
			throw new ReadStudentsFromDBExeption(e);
		} finally {
			if (connection != null) {
				ConnectionsPoolService.returnConnection(connection);
			}
		}
	}
}
