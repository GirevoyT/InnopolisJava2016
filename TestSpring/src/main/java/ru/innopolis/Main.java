package ru.innopolis;

import ru.innopolis.server.entity.LectionsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;

/**
 * Created by Girevoy.T on 28.10.2016.
 */
public class Main {
	private static final String PERSISTENT_UNIT_NAME = "item-manager-pu";

	private static final EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManager getEm() {
		return emf.createEntityManager();
	}

	public static void main(String[] args) {
		System.out.println("Success");


		EntityManager entityManager = getEm();

		LectionsEntity lectionsEntity = new LectionsEntity();

		lectionsEntity.setDate(Calendar.getInstance().getTime());
		lectionsEntity.setDescription("ksjdfhksdjhfkjsdf");
		lectionsEntity.setTopic("LESSON SUPER");
		lectionsEntity.setDuration(2);

		entityManager.getTransaction().begin();
		entityManager.merge(lectionsEntity);
		entityManager.getTransaction().commit();
		lectionsEntity = entityManager.find(LectionsEntity.class,1);
		entityManager.close();
		System.out.println(lectionsEntity);
	}

}
