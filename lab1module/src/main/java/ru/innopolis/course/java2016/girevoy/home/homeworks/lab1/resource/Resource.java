package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.resource;

/**
 * Created by Arxan on 08.10.2016.
 */
public abstract class Resource<T> extends Thread{
	private volatile boolean isComplite;
	private int countOfListeners;

	protected Resource (ThreadGroup threadGroup,String name) {
		super(threadGroup,name);
	}
	/**
	 * Этот метод добавляет слушателя (кого то надо notify)
	 */
	public synchronized void addListener() {
		this.countOfListeners++;
	}

	protected synchronized int getCountOfListeners() {
		return countOfListeners;
	}
	/**
	 * Этот метод убирает 1 слушателя
	 */
	public synchronized void takeTheListener() {
		this.countOfListeners--;
	}
	/**
	 * Этот мерод возвращает true если есть следующий объект для возврата методом next()
	 * @return
	 */
	public abstract boolean hasNext();
	/**
	 * Этот метод возвращает следующий объект из ресурса
	 * @return
	 */
	public abstract T next();
	/**
	 * Этот метод возвращает статус: обработан ли реурс полностью
	 * @return
	 */
	public boolean isComplite() {
		return isComplite;
	}

	/**
	 * Этот метод устанавливает флаг что ресурс обработан полностью
	 * @return
	 */
	protected void compliteResource() {
		isComplite = true;
	}
}
