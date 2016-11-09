package ru.innopolis.common.models.lection;

import ru.innopolis.common.models.lection.exeptions.LectionServiceDataExeption;

import java.util.List;

/**
 * Интерфейс сервисов для модели лекции
 */
public interface LectionService {
	/**
	 * Метод для получения всех списка всех лекций
	 * @return список лекций
	 * @throws LectionServiceDataExeption
	 */
	public List<Lection> getLectionsList() throws LectionServiceDataExeption;
}
