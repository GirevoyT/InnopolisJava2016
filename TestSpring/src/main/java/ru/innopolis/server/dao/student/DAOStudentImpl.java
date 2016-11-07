package ru.innopolis.server.dao.student;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ru.innopolis.common.models.student.Student;
import ru.innopolis.mapper.MapperFactoryInstance;
import ru.innopolis.server.dao.exeptions.DAOExeption;
import ru.innopolis.server.database.EntityManagerFactoryInstance;
import ru.innopolis.server.entity.LectionsEntity;
import ru.innopolis.server.entity.StudentsEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Arxan on 31.10.2016.
 */
@Slf4j
public class DAOStudentImpl implements DAOStudent {
	static {
		MapperFactoryInstance.getMapperFactoryInstance().classMap(Student.class, StudentsEntity.class)
				.byDefault()
				.register();
	}
	private static MapperFacade mapper = MapperFactoryInstance.getMapperFactoryInstance().getMapperFacade();


	@Override
	public List<Student> getStudentsList() throws DAOExeption {
		EntityManager entityManager = null;
		List<Student> result = null;
		try {
			entityManager = EntityManagerFactoryInstance.getEntityManager();
			List<LectionsEntity> resultTmp = entityManager.createQuery("from StudentsEntity").getResultList();
			result = mapper.mapAsList(resultTmp,Student.class);
		} catch (Exception e) {
			throw new DAOExeption("Ошибка получении StudentsList");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return result;
	}

	@Override
	public List<Student> getStudentListWithFilterByFirstname(String firstname) throws DAOExeption {
		EntityManager entityManager = null;
		List<Student> result = null;
		try {
			entityManager = EntityManagerFactoryInstance.getEntityManager();
			StringBuilder stringBuilder = new StringBuilder()
					.append("from StudentsEntity where firstname='")
					.append(firstname)
					.append("'");
			List<StudentsEntity> resultTmp = entityManager.createQuery(stringBuilder.toString()).getResultList();
			result = mapper.mapAsList(resultTmp,Student.class);
		} catch (Exception e) {
			throw new DAOExeption("Ошибка получении StudentsList with Filter");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return result;
	}

	@Override
	public Student getStudentById(int id) throws DAOExeption {
		EntityManager entityManager = null;
		Student result = null;
		try {
			entityManager = EntityManagerFactoryInstance.getEntityManager();
			StudentsEntity resultTmp = entityManager.find(StudentsEntity.class,id);
			result = mapper.map(resultTmp,Student.class);
		} catch (Exception e) {
			throw new DAOExeption("Ошибка получении Student по id");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return result;
	}

	@Override
	public void deleteStudentFromBase(int studentId) throws DAOExeption {
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactoryInstance.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.find(StudentsEntity.class,studentId));
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOExeption("Ошибка при удалении Student");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public void addStudentToBase(Student student) throws DAOExeption {
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactoryInstance.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(mapper.map(student,StudentsEntity.class));
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOExeption("Ошибка при добавлении нового Student");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}


}
