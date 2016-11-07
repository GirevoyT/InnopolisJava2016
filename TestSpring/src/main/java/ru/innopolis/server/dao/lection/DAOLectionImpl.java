package ru.innopolis.server.dao.lection;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ru.innopolis.common.models.lection.Lection;
import ru.innopolis.mapper.MapperFactoryInstance;
import ru.innopolis.server.dao.exeptions.DAOExeption;
import ru.innopolis.server.database.EntityManagerFactoryInstance;
import ru.innopolis.server.entity.LectionsEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
@Slf4j
public class DAOLectionImpl implements DAOLection {
	static {
		MapperFactoryInstance.getMapperFactoryInstance().classMap(Lection.class, LectionsEntity.class)
				.byDefault()
				.register();
	}
	private static MapperFacade mapper = MapperFactoryInstance.getMapperFactoryInstance().getMapperFacade();

	@Override
	public List<Lection> getLectionsList() throws DAOExeption {
		EntityManager entityManager = null;
		List<Lection> result = null;
		try {
			entityManager = EntityManagerFactoryInstance.getEntityManager();
			List<LectionsEntity> resultTmp = entityManager.createQuery("from LectionsEntity").getResultList();
			result = mapper.mapAsList(resultTmp,Lection.class);
		} catch (Exception e) {
			throw new DAOExeption("Ошибка получении LectionsList");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return result;
	}

	@Override
	public void addNewLection(Lection lection) throws DAOExeption {
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactoryInstance.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(mapper.map(lection,LectionsEntity.class));
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOExeption("Ошибка при добавлении нового Lection");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public void deleteLection(Lection lection) throws DAOExeption {
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactoryInstance.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.find(LectionsEntity.class,lection.getId()));
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOExeption("Ошибка при удалении Lection");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
}
