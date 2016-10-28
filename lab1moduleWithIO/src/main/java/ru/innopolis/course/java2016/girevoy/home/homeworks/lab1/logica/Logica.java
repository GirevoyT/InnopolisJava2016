package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica;

/**
 * Created by Arxan on 10.10.2016.
 */
public interface Logica<T,R> {
	/**
	 * Основаной метод логики В нём происходят все вычисления и вывод (при необходимости)
	 * @param arg
	 */
	public void logica(T arg);

	/**
	 * Метод при необходимости возвращает промежуточный результат
	 * @return
	 */
	public R getResult();
}
