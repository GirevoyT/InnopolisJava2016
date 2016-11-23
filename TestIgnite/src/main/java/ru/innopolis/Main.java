package ru.innopolis;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

/**
 * Created by MasterPc on 22.11.2016.
 */
public class Main {
	public static void main(String[] args) throws BeansException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");

		IgniteConfiguration igniteConfiguration = (IgniteConfiguration) ctx.getBean("ignite.cfg");

		Ignite ignite = Ignition.start(igniteConfiguration);
		// get or create cache
		IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

		cache.clear();
		for (int i = 0 ; i <10;i++) {
			cache.put(i,"Мвахаха х"+i);
		}


//		System.out.println(cache.getAndPut(11,"Test"));
		cache.forEach((e) -> System.out.println(e.getValue()));


		ignite.close();

	}
}
