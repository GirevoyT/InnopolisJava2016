package ru.innopolis.server.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.common.models.student.Sex;
import ru.innopolis.common.models.student.Student;
import ru.innopolis.loggerhelp.LoggerHelp;
import ru.innopolis.server.dao.exeptions.DAOExeption;
import ru.innopolis.server.database.ConnectionPoolService;
import ru.innopolis.server.database.exeptions.NoFreeConnectionExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Arxan on 31.10.2016.
 */
public class DAOStudentImpl implements DAOStudent {
	@Autowired
	private ConnectionPoolService connectionsPoolService;

	private static Logger logger = LoggerFactory.getLogger(DAOStudentImpl.class);

	public void setConnectionsPoolService(ConnectionPoolService connectionsPoolService) {
		this.connectionsPoolService = connectionsPoolService;
	}

	private ArrayList<Student> getStudentsByQuery (String query) throws DAOExeption {
		ArrayList<Student> students = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionsPoolService.getConnectionWithWait();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			LinkedList<Student> studentsList = new LinkedList<>();
			while (resultSet.next()) {
				Student tmp = new Student();
				tmp.setId(resultSet.getInt(1));
				tmp.setFirstname(resultSet.getString(2));
				tmp.setLastname(resultSet.getString(3));
				tmp.setSex(resultSet.getBoolean(4) ? Sex.Male : Sex.Female);
				tmp.setBirthDate(resultSet.getDate(5));
				students.add(tmp);
			}
		} catch (NoFreeConnectionExeption e) {
			throw new DAOExeption("Ошибка получения конекта",e);
		} catch (SQLException e) {
			throw new DAOExeption("Ошибка работы с базой",e);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					LoggerHelp.printExeptionInWarn(e,logger);
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					LoggerHelp.printExeptionInWarn(e,logger);
				}
			}

			connectionsPoolService.returnConnection(connection);
		}
		return students;
	}

	@Override
	public ArrayList<Student> getStudentsList() throws DAOExeption {
		StringBuilder sql = new StringBuilder();
		sql.append("Select id,firstname,lastname,sex,birth_date from Students");
		return getStudentsByQuery(sql.toString());
	}

	@Override
	public ArrayList<Student> getStudentListWithFilterByFirstname(String firstname) throws DAOExeption {
		StringBuilder sql = new StringBuilder();
		sql.append("Select id,firstname,lastname,sex,birth_date from Students ")
				.append("WHERE firstname='").append(firstname).append("'");
		return getStudentsByQuery(sql.toString());
	}

	@Override
	public Student getStudentById(int id) throws DAOExeption {
		StringBuilder sql = new StringBuilder();
		sql.append("Select id,firstname,lastname,sex,birth_date from Students WHERE id=").append(id);
		ArrayList<Student> students = getStudentsByQuery(sql.toString());
		if (students.size() == 0) {
			throw new DAOExeption("Студента с указаным ID нет");
		}
		return students.get(0);
	}

	private int updateStudentsByQuery (String query) throws DAOExeption {
		int result;
		Connection connection = null;
		Statement statement = null;
		try {
			connection = connectionsPoolService.getConnectionWithWait();
			statement = connection.createStatement();
			result = statement.executeUpdate(query);
		} catch (NoFreeConnectionExeption e) {
			throw new DAOExeption("Ошибка получения конекта",e);
		} catch (SQLException e) {
			throw new DAOExeption("Ошибка работы с базой",e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					LoggerHelp.printExeptionInWarn(e,logger);
				}
			}
			connectionsPoolService.returnConnection(connection);
		}
		return result;
	}

	@Override
	public void deleteStudentFromBase(int studentId) throws DAOExeption {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM Students WHERE id=").append(studentId);
		if (updateStudentsByQuery(sql.toString()) != 1) {
			throw new DAOExeption("Студента с таким ID нету");
		}
	}

	@Override
	public void addStudentToBase(Student student) throws DAOExeption {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Students (firstname,lastname,sex,birth_date) VALUES('")
				.append(student.getFirstname()).append("','")
				.append(student.getLastname()).append("',")
				.append(student.getSex().equals(Sex.Female) ? 0 : 1).append(",'")
				.append(new SimpleDateFormat("dd.MM.yyyy").format(student.getBirthDate())).append("')");
		if (updateStudentsByQuery(sql.toString()) != 1) {
			throw new DAOExeption("Добавление не прошло");
		}
	}


}
