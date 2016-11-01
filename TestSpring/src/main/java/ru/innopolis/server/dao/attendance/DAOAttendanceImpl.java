package ru.innopolis.server.dao.attendance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.common.models.attendance.Attendance;
import ru.innopolis.loggerhelp.LoggerHelp;
import ru.innopolis.server.dao.student.exeptions.DAOExeption;
import ru.innopolis.server.database.ConnectionPoolService;
import ru.innopolis.server.database.exeptions.NoFreeConnectionExeption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public class DAOAttendanceImpl implements DAOAttendance{
	@Autowired
	private ConnectionPoolService connectionsPoolService;

	public void setConnectionsPoolService(ConnectionPoolService connectionsPoolService) {
		this.connectionsPoolService = connectionsPoolService;
	}

	private static Logger logger = LoggerFactory.getLogger(DAOAttendanceImpl.class);

	private List<Attendance> getAttendancesListByQuery(String query) throws DAOExeption {
		List<Attendance> attendances = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionsPoolService.getConnectionWithWait();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Attendance tmp = new Attendance();
				tmp.setLection_id(resultSet.getInt(1));
				tmp.setStudent_id(resultSet.getInt(2));
				attendances.add(tmp);
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
		return attendances;
	}

	@Override
	public List<Attendance> getAttendacesList() throws DAOExeption {
		StringBuilder sql = new StringBuilder();
		sql.append("Select lection_id,student_id from Attendance");
		return getAttendancesListByQuery(sql.toString());
	}

	private int updateAttendancesByQuery(String query) throws DAOExeption {
		Connection connection = null;
		Statement statement = null;
		int result;
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
	public void addNewAttendance(Attendance attendance) throws DAOExeption {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Attendance (student_id,lection_id) VALUES(")
				.append(attendance.getStudent_id()).append(",")
				.append(attendance.getLection_id()).append(")");
		if (updateAttendancesByQuery(sql.toString()) != 1) {
			throw new DAOExeption("Добавление не прошло");
		}
	}

	@Override
	public void deleteAttendance(Attendance attendance) throws DAOExeption {
		StringBuilder sql = new StringBuilder();
		sql.append("BEGIN TRANSACTION\n")
				.append("DELETE FROM Attendance WHERE student_id=").append(attendance.getStudent_id()).append(" AND ")
				.append("lection_id=").append(attendance.getLection_id()).append("\n")
				.append("COMMIT");
		if (updateAttendancesByQuery(sql.toString()) != 1) {
			throw new DAOExeption("Такого интенданс нету");
		}
	}

}
