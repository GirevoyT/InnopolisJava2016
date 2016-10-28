package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.devourers.Devourer;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica.Logica;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.Resource;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.ResourceChecker;

import java.math.BigInteger;

/**
 * Created by Arxan on 08.10.2016.
 */
public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	private static Logica<Integer,BigInteger> logica;

	public static void main(String[] args){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"io.xml"});
		logica = (Logica<Integer, BigInteger>) applicationContext.getBean("logica");

		logger.info("Старт приложения");
		ThreadGroup threadGroup = new ThreadGroup("Group1");



		Resource<Integer> resource = ResourceChecker.createResourceBySting("./src/main/resources/Resource1",threadGroup);
		resource.start();
		//DeepThought deepThought = new DeepThought(logica,threadGroup);
		Object[] objects = new Object[2];
		objects[0] = logica;
		objects[1] = threadGroup;
		DeepThought deepThought = (DeepThought)applicationContext.getBean("resource",objects);
		deepThought.start();
		Devourer devourer = new Devourer(resource,deepThought,threadGroup);
		devourer.start();

		logger.info("Все объекты созданы и запущенны");

		try {
			Thread.sleep(2000);
			threadGroup.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Остановленны оставшиеся потоки");
	}

	public void setLogica(Logica<Integer,BigInteger> logica) {
		this.logica = logica;
	}

	public Logica<Integer,BigInteger> getLogica() {
		return logica;
	}
}
