package ru.innopolis.web.config;

/**
 * Created by Girevoy.T on 03.11.2016.
 */

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.innopolis.server.dao.attendance.DAOAttendanceImpl;
import ru.innopolis.server.dao.lection.DAOLectionImpl;
import ru.innopolis.server.dao.student.DAOStudentImpl;
import ru.innopolis.server.database.ConnectionsPoolServiceImpl;
import ru.innopolis.server.models.lection.LectionServiceImpl;
import ru.innopolis.server.models.student.StudentServiceImpl;
import ru.innopolis.server.models.studentAttendences.StudentAttendanceServiceImpl;
import ru.innopolis.server.models.studentXLection.StudentXLectionServiceImpl;

@Configuration

public class AppContextConfig {
	@Bean(name = "connectionsPoolService",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public ConnectionsPoolServiceImpl connectionsPoolServiceImpl() {
		return new ConnectionsPoolServiceImpl();
	}
	@Bean(name = "daoStudent",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public DAOStudentImpl daoStudent() {
		return new DAOStudentImpl();
	}
	@Bean(name = "daoAttendance",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public DAOAttendanceImpl daoAttendance() {
		return new DAOAttendanceImpl();
	}
	@Bean(name = "daoLection",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public DAOLectionImpl daoLection() {
		return new DAOLectionImpl();
	}
	@Bean(name = "studentAttendanceService",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public StudentAttendanceServiceImpl studentAttendanceService() {
		return new StudentAttendanceServiceImpl();
	}
	@Bean(name = "studentService",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public StudentServiceImpl studentService() {
		return new StudentServiceImpl();
	}
	@Bean(name = "lectionService",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public LectionServiceImpl lectionService() {
		return new LectionServiceImpl();
	}
	@Bean(name = "studentXLectionService",
		autowire = Autowire.BY_NAME)
	@Scope("singleton")
	public StudentXLectionServiceImpl studentXLectionService() {
		return new StudentXLectionServiceImpl();
	}
}
