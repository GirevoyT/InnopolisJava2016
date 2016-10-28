package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica.Logica;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Arxan on 08.10.2016.
 */
public class DeepThought<T>{
	private Queue<T> queue = new PriorityQueue<>();
	private Logica<T,?> logica;
	private static Logger logger= LoggerFactory.getLogger(DeepThought.class);
	private Thread thread;

	/**
	 * Метод запускающий внутрений поток (при необходимости можно расширить до потоКОВ)
	 */
	public void start() {
		thread.start();
	}

	public DeepThought(Logica<T,?> logica,ThreadGroup threadGroup) {
		logger.debug("Запущен конструктор думателя DeepThought: {}",DeepThought.this.hashCode());
		this.logica = logica;
		this.thread = new Thread(threadGroup,"Поток думателя№1") {
			public void run () {
				logger.debug("Начал работать поток думателя DeepThought: {}",DeepThought.this.hashCode());
				try {
					while(!isInterrupted()) {
						T tmpT = null;
						logger.debug("Проверка и ожидание следующего елемента в очереди");
						while (true) {
							synchronized (DeepThought.this) {
								logger.debug("Внутрений поток думателя захватил блокировку DeepThought: {}", DeepThought.this.hashCode());
								synchronized (queue) {
									logger.debug("Внутрений поток думателя захватил блокировку queue: {}", queue.hashCode());
									if (!queue.isEmpty()) {
										tmpT = queue.poll();
										logger.debug("Очередь не пуста, взят следующий элемент из queue");
										break;
									}
								}
								logger.debug("Освобождена блокировка queue: {}", queue.hashCode());
								logger.debug("Постановка на ожинаие от DeepThought: {}, состояние interrupt: {}", DeepThought.this.hashCode(), this.isInterrupted());
								DeepThought.this.wait();
								logger.debug("Проснулся из ожадиния DeepThought: {}", DeepThought.this.hashCode());
							}
							logger.debug("Освобождена блокировка DeepThought: {}", DeepThought.this.hashCode());
						}
						logger.debug("Выход из цикла ожидания следующего эллемента queue и запуск логики");
						logica.logica(tmpT);
						logger.debug("Логика отработала");
					}
				} catch (InterruptedException e) {
					if (logger.isWarnEnabled()) {
						ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						PrintStream printStream = new PrintStream(byteArrayOutputStream);
						e.printStackTrace(printStream);
						logger.warn(byteArrayOutputStream.toString());
					}
				}
				logger.debug("Остановка внутреннего потока думателя DeepThought: {}",DeepThought.this.hashCode());
			}
		};
		logger.debug("Конструктор думателя отработал DeepThought: {}",DeepThought.this.hashCode());
	}

	/**
	 * Метод добавляющий объект data в очередь обработки
	 * @param data
	 */
	public void addData(T data) {
		logger.debug("Запущен addData думателя, далее блокировка с queue: {}",queue.hashCode());
		synchronized (queue) {
			logger.debug("addData захватил блокировку от queue: {}",queue.hashCode());
			queue.add((T)data);
		}
		logger.debug("Освобождена блокировка queue: {}  и закончено добавление данных в очередь",queue.hashCode());
	}

	/**
	 * Метод возвращает класс внутреней логики
	 * @return
	 */
	public Logica<T,?> getLogica() {
		return logica;
	}

	/**
	 * Метод устанавливает внутренюю логику
	 * @param logica
	 */
	public void setLogica(Logica<T,?> logica) {
		this.logica = logica;
	}
}
