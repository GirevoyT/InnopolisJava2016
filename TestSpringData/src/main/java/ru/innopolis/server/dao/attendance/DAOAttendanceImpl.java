package ru.innopolis.server.dao.attendance;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ru.innopolis.common.models.attendance.Attendance;
import ru.innopolis.mapper.MapperFactoryInstance;
import ru.innopolis.server.dao.exeptions.DAOExeption;
import ru.innopolis.server.database.EntityManagerFactoryInstance;
import ru.innopolis.server.entity.AttendanceEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
@Slf4j
public class DAOAttendanceImpl implements DAOAttendance{
	static {
		MapperFactoryInstance.getMapperFactoryInstance().classMap(Attendance.class, AttendanceEntity.class)
				.field("lectionId","key.lectionId")
				.field("studentId","key.studentId")
				.register();
		MapperFactoryInstance.getMapperFactoryInstance().classMap(AttendanceEntity.EmbKey.class, Attendance.class)
				.byDefault()
				.register();
	}
	private static MapperFacade mapper = MapperFactoryInstance.getMapperFactoryInstance().getMapperFacade();

	@Override
	public List<Attendance> getAttendacesList() throws DAOExeption{
		EntityManager entityManager = null;
		List<Attendance> result = null;
		try {
			entityManager = EntityManagerFactoryInstance.getEntityManager();
			List<AttendanceEntity> resultTmp = entityManager.createQuery("from AttendanceEntity").getResultList();
			result = mapper.mapAsList(resultTmp,Attendance.class);
		} catch (Exception e) {
			throw new DAOExeption("Ошибка получении AttendacesList");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return result;
	}

	@Override
	public void addNewAttendance(Attendance attendance) throws DAOExeption{
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactoryInstance.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(mapper.map(attendance,AttendanceEntity.class));
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOExeption("Ошибка при добавлении нового attendace");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public void deleteAttendance(Attendance attendance) throws DAOExeption {
		AttendanceEntity.EmbKey embKey = mapper.map(attendance,AttendanceEntity.EmbKey.class);
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactoryInstance.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.find(AttendanceEntity.class,embKey));
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOExeption("Ошибка при удалении attendace");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

}
