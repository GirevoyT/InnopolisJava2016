package ru.innopolis;

import ma.glasnost.orika.MapperFacade;
import ru.innopolis.common.models.student.Sex;
import ru.innopolis.common.models.student.Student;
import ru.innopolis.mapper.MapperFactoryInstance;
import ru.innopolis.server.dao.exeptions.DAOExeption;
import ru.innopolis.server.database.EntityManagerFactoryInstance;
import ru.innopolis.server.entity.StudentsEntity;

import java.util.Calendar;

/**
 * Created by Girevoy.T on 28.10.2016.
 */
public class Main {
	static {
		MapperFactoryInstance.getMapperFactoryInstance().classMap(Student.class, StudentsEntity.class)
				.byDefault()
				.register();
	}
	private static MapperFacade mapper = MapperFactoryInstance.getMapperFactoryInstance().getMapperFacade();

	public static void main(String[] args) throws DAOExeption {
		System.out.println("Success");

		Student student = new Student();
		student.setBirthDate(Calendar.getInstance().getTime());
		student.setSex(Sex.Female);
		student.setFirstname("asd");
		student.setLastname("asd");


		StudentsEntity studentsEntity = mapper.map(student,StudentsEntity.class);

//		List<Attendance> attendanceList = daoAttendance.getAttendacesList();

//		entityManager.getTransaction().begin();
//
//		entityManager.persist(t1);
//
//		entityManager.getTransaction().commit();
//
//		entityManager.refresh(t1);
//
//		entityManager.close();
//
		EntityManagerFactoryInstance.closeEMF();
	}

}
