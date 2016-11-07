package ru.innopolis.server.models.studentAttendences;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.common.models.attendance.Attendance;
import ru.innopolis.common.models.student.Student;
import ru.innopolis.common.models.studentAttendences.StudentAttendance;
import ru.innopolis.common.models.studentAttendences.StudentAttendanceService;
import ru.innopolis.common.models.studentAttendences.exeptions.StudentAttendanceDataExeption;
import ru.innopolis.server.dao.attendance.DAOAttendance;
import ru.innopolis.server.dao.student.DAOStudent;
import ru.innopolis.server.dao.exeptions.DAOExeption;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public class StudentAttendanceServiceImpl implements StudentAttendanceService {
	@Autowired
	private DAOStudent daoStudent;

	public void setDaoStudent(DAOStudent daoStudent) {
		this.daoStudent = daoStudent;
	}
	@Autowired
	private DAOAttendance daoAttendance;

	public void setDaoAttendance(DAOAttendance daoAttendance) {
		this.daoAttendance = daoAttendance;
	}

	@Override
	public List<StudentAttendance> getSudentAttendanceList() throws StudentAttendanceDataExeption {
		List<StudentAttendance> studentAttendances =  new ArrayList<>();
		try {
			List<Student> students = daoStudent.getStudentsList();
			List<Attendance> attendances = daoAttendance.getAttendacesList();
			for (Student student : students) {
				StudentAttendance tmp = new StudentAttendance();
				tmp.setStudent(student);
				tmp.setLectionCount(0);
				for (Attendance attendance : attendances) {
					if (attendance.getStudentId() == student.getId()) {
						tmp.setLectionCount(tmp.getLectionCount()+1);
					}
				}
				studentAttendances.add(tmp);
			}
		} catch (DAOExeption e) {
			throw new StudentAttendanceDataExeption(e);
		}

		return studentAttendances;
	}
}
