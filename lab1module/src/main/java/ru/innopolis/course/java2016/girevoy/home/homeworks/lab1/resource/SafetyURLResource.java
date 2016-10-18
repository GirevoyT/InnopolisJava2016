package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.exeptions.NotIntegerExeption;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Arxan on 08.10.2016.
 */
public class SafetyURLResource extends Resource<Integer> {

	private final Queue<Integer> queue = new PriorityQueue<>();
	private URL url;
	private static Logger logger= LoggerFactory.getLogger(SafetyURLResource.class);

	/**
	 * Конструктор который создает поток для разбора ресурса с
	 * @param url
	 * принадлежащей к группе
	 * @param threadGroup
	 * необходимой для остановки всех потоков в случае ошибки
	 */
	public SafetyURLResource(String url, ThreadGroup threadGroup) throws MalformedURLException {
		super(threadGroup,"Поток ресурса");
		this.url = new URL(url);
		logger.debug("Создан поток ресурса из ссылки {}",url);
	}


	public void run() {
		logger.debug("Поток ресурса {} начал работу",this.hashCode());
		try (Scanner scannerString = new Scanner(url.openStream())) {
			logger.debug("Поток ресурса {}  открыл url {} и передал в сканер",this.hashCode(), url.toString());
			int stringCount = 0;
			stringWhile:
			while (scannerString.hasNextLine()) {
				Scanner scannerInt = new Scanner(scannerString.nextLine());
				stringCount++;
				intWhile:
				while (!this.isInterrupted() && scannerInt.hasNextInt()) {
					Integer tmpInt = scannerInt.nextInt();
					logger.debug("Поток ресурса {} ждёт блокировку по queue",this.hashCode());
					synchronized (queue) {
						queue.add(tmpInt);
					}
					logger.debug("Поток ресурса {} забрал блокировка по queue добавил новый эллемент и освободил блокировку",this.hashCode());

					logger.debug("Поток ресурса {} ждёт блокировку по this",this.hashCode());
					synchronized (this) {
						if (getCountOfListeners() > 0) {
							this.notify();
							takeTheListener();
						}
					}
					logger.debug("Поток ресурса {} забрал блокировку по this разбудил слушателя и освободил блокировку",this.hashCode());
				}
				if (!this.isInterrupted() && scannerInt.hasNext()) {
					this.getThreadGroup().interrupt();
					logger.warn("Ошибка при разборе ресурса {}(встретилось не число)",this.hashCode());
					new NotIntegerExeption("Ошибка при разборе ресурса (встретилось не число).",stringCount,url.toString()).printStackTrace();
					break stringWhile;
				}
			}
		} catch (IOException e) {
			if (logger.isWarnEnabled()) {
				logger.warn("Ошибка чтения файла");
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(byteArrayOutputStream);
				e.printStackTrace(printStream);
				logger.warn(byteArrayOutputStream.toString());
			}
			e.printStackTrace();
			this.getThreadGroup().interrupt();
		} finally {
			logger.warn("Ресурс отмечается как законченный",this.hashCode());
			compliteResource();
			logger.debug("Поток ресурса {} ждёт блокировку по this",this.hashCode());
			synchronized (this) {
				if (getCountOfListeners() > 0) {
					this.notifyAll();
				}
			}
			logger.debug("Поток ресурса {} забрал блокировку по this и разбудил всех слушателей",this.hashCode());
		}
	}

	@Override
	/**
	 * Проверяет пуста ли очередь
	 */
	public boolean hasNext() {
		logger.debug("Отработал hasNext() в ресурсе {}" , this.hashCode());
		synchronized (queue) {
			return !queue.isEmpty();
		}
	}

	@Override
	/**
	 * Возвращает следующий объект из очереди
	 */
	public Integer next() {
		logger.debug("Отработал next() в ресурсе {}" , this.hashCode());
		synchronized (queue) {
			return queue.poll();
		}
	}
}
