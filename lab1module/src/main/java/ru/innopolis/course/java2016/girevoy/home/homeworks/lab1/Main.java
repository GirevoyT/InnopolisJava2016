package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.devourers.Devourer;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica.Logica;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica.MyTaskIntegerLogica;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.Resource;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.ResourceChecker;

import java.math.BigInteger;

/**
 * Created by Arxan on 08.10.2016.
 */
public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args){
		logger.info("Старт приложения");
		ThreadGroup threadGroup = new ThreadGroup("Group1");
		Resource<Integer> resource1 = null;
		Resource<Integer> resource2 = null;
		resource1 = ResourceChecker.createResourceBySting("./src/main/resources/Resource1",threadGroup);
		resource2 = ResourceChecker.createResourceBySting("./src/main/resources/Resource2",threadGroup);
		if (resource1 == null || resource2 == null){
			logger.warn("Один из ресурсов не существует");
			return;
		}
		resource1.start();
		resource2.start();
		Logica<Integer,BigInteger> myLogica1 = new MyTaskIntegerLogica();
		Logica<Integer,BigInteger> myLogica2 = new MyTaskIntegerLogica();
		DeepThought deepThought1 = new DeepThought(myLogica1,threadGroup);
		deepThought1.start();
		DeepThought deepThought2 = new DeepThought(myLogica2,threadGroup);
		deepThought2.start();
		Devourer devourer1 = new Devourer(resource1,deepThought1,threadGroup);
		devourer1.start();
		Devourer devourer2 = new Devourer(resource2,deepThought1,threadGroup);
		devourer2.start();
		Devourer devourer3 = new Devourer(resource2,deepThought2,threadGroup);
		devourer3.start();
		logger.info("Все объекты созданы и запущенны");

		try {
			Thread.sleep(2000);
			threadGroup.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Остановленны оставшиеся потоки");
	}
}
