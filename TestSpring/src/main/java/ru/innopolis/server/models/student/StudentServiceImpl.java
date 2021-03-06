package ru.innopolis.server.models.student;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.common.models.student.Sex;
import ru.innopolis.common.models.student.Student;
import ru.innopolis.common.models.student.StudentService;
import ru.innopolis.common.models.student.exeptions.CreateStudentExeption;
import ru.innopolis.common.models.student.exeptions.StudentServiceDataExeption;
import ru.innopolis.server.dao.exeptions.DAOExeption;
import ru.innopolis.server.dao.student.DAOStudent;

import java.util.Date;
import java.util.List;

/**
 * Created by Arxan on 31.10.2016.
 */
public class StudentServiceImpl implements StudentService {
	@Autowired
	private DAOStudent daoStudent;

	public void setDaoStudent(DAOStudent daoStudent) {
		this.daoStudent = daoStudent;
	}

	@Override
	public Student createNewStudent(String fistname, String lastname, Sex sex, Date birthDate) throws CreateStudentExeption {
		if (fistname == null || lastname == null || sex == null || birthDate == null) {
			throw new CreateStudentExeption("Одно из переданных значений null");
		}
		Student result =  new Student();
		result.setFirstname(fistname);
		result.setLastname(lastname);
		result.setSex(sex);
		result.setBirthDate(birthDate);
		return result;
	}

	@Override
	public List<Student> getStudentsList() throws StudentServiceDataExeption {
		try {
			return daoStudent.getStudentsList();
		} catch (DAOExeption e) {
			throw new StudentServiceDataExeption(e);
		}
	}

	@Override
	public List<Student> getStudentListWithFilterByFirstname(String firstname) throws StudentServiceDataExeption {
		try {
			return daoStudent.getStudentListWithFilterByFirstname(firstname);
		} catch (DAOExeption e) {
			throw new StudentServiceDataExeption(e);
		}
	}

	@Override
	public Student getStudentById(int id) throws StudentServiceDataExeption {
		try {
			return daoStudent.getStudentById(id);
		} catch (DAOExeption e) {
			throw new StudentServiceDataExeption(e);
		}
	}

	@Override
	public void deleteStudentFromBase(Student student) throws StudentServiceDataExeption {
		deleteStudentFromBaseById(student.getId());
	}

	@Override
	public void deleteStudentFromBaseById(int id) throws StudentServiceDataExeption {
		try {
			daoStudent.deleteStudentFromBase(id);
		} catch (DAOExeption e) {
			throw new StudentServiceDataExeption(e);
		}
	}

	@Override
	public void addStudentToBase(Student student) throws StudentServiceDataExeption {
		try {
			daoStudent.addStudentToBase(student);
		} catch (DAOExeption e) {
			throw new StudentServiceDataExeption(e);
		}
	}
}
