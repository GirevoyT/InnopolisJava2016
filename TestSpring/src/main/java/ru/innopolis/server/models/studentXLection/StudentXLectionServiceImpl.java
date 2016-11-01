package ru.innopolis.server.models.studentXLection;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.common.models.attendance.Attendance;
import ru.innopolis.common.models.lection.Lection;
import ru.innopolis.common.models.student.Student;
import ru.innopolis.common.models.studentXLection.LectionBox;
import ru.innopolis.common.models.studentXLection.StudentXLection;
import ru.innopolis.common.models.studentXLection.StudentXLectionService;
import ru.innopolis.common.models.studentXLection.exeptions.StudentXLectionDataExeption;
import ru.innopolis.server.dao.attendance.DAOAttendance;
import ru.innopolis.server.dao.lection.DAOLection;
import ru.innopolis.server.dao.student.DAOStudent;
import ru.innopolis.server.dao.student.exeptions.DAOExeption;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public class StudentXLectionServiceImpl implements StudentXLectionService {
	@Autowired
	private DAOLection daoLection;

	public void setDaoLection(DAOLection daoLection) {
		this.daoLection = daoLection;
	}

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
	public List<StudentXLection> getSudentXLectionList() throws StudentXLectionDataExeption {
		List<StudentXLection> result = new ArrayList<>();
		try {
			List<Student> students = daoStudent.getStudentsList();
			List<Lection> lections = daoLection.getLectionsList();
			List<Attendance> attendances = daoAttendance.getAttendacesList();
			for (Student student : students) {
				StudentXLection tmp = new StudentXLection();
				result.add(tmp);
				tmp.setStudent(student);
				tmp.setLectionBox(new ArrayList<LectionBox>());
				for (Lection lection: lections) {
					LectionBox tmpbox = new LectionBox();
					tmp.getLectionBox().add(tmpbox);
					tmpbox.setLection(lection);
					for (Attendance attendance: attendances) {
						if (lection.getId() == attendance.getLection_id()) {
							if (student.getId() == attendance.getStudent_id()) {
								tmpbox.setPresence(true);
							}
						}
					}
				}
			}
		} catch (DAOExeption e) {
			throw new StudentXLectionDataExeption(e);
		}
		return result;
	}

	@Override
	public void noteAttendance(int studentId, int lectionId, boolean state) throws StudentXLectionDataExeption {
		Attendance attendance = new Attendance();
		attendance.setLection_id(lectionId);
		attendance.setStudent_id(studentId);
		try {
			if (state) {
				daoAttendance.addNewAttendance(attendance);
			} else {
				daoAttendance.deleteAttendance(attendance);
			}
		} catch (DAOExeption e) {
			throw new StudentXLectionDataExeption("Ошибка с базой",e);
		}


	}

}
