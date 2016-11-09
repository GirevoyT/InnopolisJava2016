package ru.innopolis.common.models.studentXLection;

import ru.innopolis.common.models.studentXLection.exeptions.StudentXLectionDataExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 01.11.2016.
 */
public interface StudentXLectionService {
	/**
	 * Метод для получения списка StudentXLection
	 * @return Список
	 * @throws StudentXLectionDataExeption
	 */
	public List<StudentXLection> getSudentXLectionList() throws StudentXLectionDataExeption;

	/**
	 * Метод который меняет в базе статус посещения определённым студентов лекции
	 * @param StudentId id студента
	 * @param LectionId id лекции
	 * @param state статус
	 * @throws StudentXLectionDataExeption
	 */
	public void noteAttendance(int StudentId,int LectionId,boolean state) throws StudentXLectionDataExeption;
}
