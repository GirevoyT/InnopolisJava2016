package ru.innopolis.course.java2016.girevoy.lessons.lesson27;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Girevoy.T on 08.11.2016.
 */
public abstract class ChainEllement {
	@Getter
	@Setter
	private ChainEllement next;

	protected abstract Object doWork(Object msg);

	/**
	 * Публичный метод для запуска элемента цепи
	 * @param msg передаваемое сообщение
	 */
	public void start(Object msg) {
		Object result = doWork(msg);
		if (next != null) {
			next.start(result);
		}
	}
}
