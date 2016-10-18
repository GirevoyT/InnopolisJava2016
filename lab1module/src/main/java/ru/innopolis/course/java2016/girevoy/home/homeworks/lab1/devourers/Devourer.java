package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.devourers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.DeepThought;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource.Resource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Arxan on 08.10.2016.
 */
public class Devourer<T> extends Thread{
	private Resource<T> resource;
	private DeepThought deepThought;
	private static Logger logger= LoggerFactory.getLogger(Devourer.class);

	/**
	 * Создает пожирателя который будет из resource передавать данные в deepThought
	 * @param resource
	 * @param deepThought
	 * @param threadGroup
	 */
	public Devourer(Resource<T> resource, DeepThought deepThought,ThreadGroup threadGroup) {
		super(threadGroup,"Поток пожирателя");
		logger.debug("Запущен конструктор пожирателя: {}",this.hashCode());
		this.resource = resource;
		this.deepThought = deepThought;
		logger.debug("Пожиратель: {} сконфигурирован",this.hashCode());
	}


	@Override
	public void run() {
		try {
			while (!isInterrupted()) {
				logger.debug("Начал работать поток Devourer: ",this.hashCode());
				T tmpObject;
				synchronized (resource) {
					logger.debug("Пожиратель: {} захватил блокировку resource: {}",this.hashCode(),resource.hashCode());
					if (resource.hasNext()) {
						tmpObject = resource.next();
						logger.debug("Пожиратель: {} забрал следующий объект из ресурса: {}",this.hashCode(),resource.hashCode());
						synchronized (deepThought) {
							logger.debug("Пожиратель: {} захватил блокировку deepThought: {}",this.hashCode(),deepThought.hashCode());
							deepThought.addData(tmpObject);
							deepThought.notify();
						}
						logger.debug("Пожиратель: {} освободил блокировку deepThought: {} , добавил в него элемент и попытался разбудить его",this.hashCode(),deepThought.hashCode());
					} else if (!resource.isComplite()) {
						resource.addListener();
						logger.debug("Пожиратель: {} не обнаружил в ресурсе следующего эллемента и встал в ожидание",this.hashCode());
						resource.wait();
						logger.debug("Пожиратель: {} проснулся и пошол на следующий круг",this.hashCode());
					} else {
						logger.debug("Пожиратель: {} ,больше не имеет в ресурсе: {} элементов и интераптится",this.hashCode(),resource.hashCode());
						this.interrupt();
					}
				}
			}
		} catch (InterruptedException e) {
			if (logger.isWarnEnabled()) {
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(byteArrayOutputStream);
				e.printStackTrace(printStream);
				logger.warn(byteArrayOutputStream.toString());
			}
		}
	}
}
