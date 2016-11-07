package ru.innopolis.server.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Arxan on 07.11.2016.
 */
public class EntityManagerFactoryInstance {
	private static final String PERSISTENT_UNIT_NAME = "item-manager-pu";
	private static final EntityManagerFactory emf;
	private EntityManagerFactoryInstance(){};
	static {
		try {
			emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	public static void closeEMF() {emf.close();}

}
