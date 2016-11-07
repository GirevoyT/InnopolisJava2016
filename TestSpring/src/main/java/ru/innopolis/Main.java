package ru.innopolis;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * Created by Girevoy.T on 28.10.2016.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Success");
		SessionFactory sessionFactory;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );

			throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
		}
		Session session = sessionFactory.openSession();
		List tmp = session.createQuery("from StudentsEntity as b where firstname='Timur'").list();
		session.close();
		sessionFactory.close();
	}

}
