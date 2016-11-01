package ru.innopolis.server.dao.lection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.common.models.lection.Lection;
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
public class DAOLectionImpl implements DAOLection {
	@Autowired
	private ConnectionPoolService connectionsPoolService;

	public void setConnectionsPoolService(ConnectionPoolService connectionsPoolService) {
		this.connectionsPoolService = connectionsPoolService;
	}

	private static Logger logger = LoggerFactory.getLogger(DAOLectionImpl.class);

	private List<Lection> getLectionsListByQuery(String query) throws DAOExeption {
		List<Lection> lections = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionsPoolService.getConnectionWithWait();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Lection tmp = new Lection();
				tmp.setId(resultSet.getInt(1));
				tmp.setTopic(resultSet.getString(2));
				tmp.setDescription(resultSet.getString(3));
				tmp.setDuration(resultSet.getInt(4));
				tmp.setDate(resultSet.getDate(5));
				lections.add(tmp);
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
		return lections;
	}

	@Override
	public List<Lection> getLectionsList() throws DAOExeption {
		StringBuilder sql = new StringBuilder();
		sql.append("Select id,topic,description,duration,date from Lections");
		return getLectionsListByQuery(sql.toString());
	}
}
