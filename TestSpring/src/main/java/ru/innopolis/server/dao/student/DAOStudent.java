package ru.innopolis.server.dao.student;

import ru.innopolis.common.models.student.Student;
import ru.innopolis.server.dao.student.exeptions.DAOExeption;

import java.util.ArrayList;

/**
 * Created by Arxan on 31.10.2016.
 */

public interface DAOStudent {
	/**
	 * Метод для получения списка студентов из БД
	 * @return
	 * @throws DAOExeption
	 */
	public ArrayList<Student> getStudentsList() throws DAOExeption;

	/**
	 * Метод для получения списка студентов из БД с фильтром по имени
	 * @param firstname имя для фильтра
	 * @return
	 * @throws DAOExeption
	 */
	public ArrayList<Student> getStudentListWithFilterByFirstname(String firstname) throws DAOExeption;

	/**
	 * Метод для получения студента по id
	 * @param id
	 * @return
	 * @throws DAOExeption
	 */
	public Student getStudentById(int id) throws DAOExeption;

	/**
	 * Метод для удаления студента из базы по id
	 * @param studentId
	 * @throws DAOExeption
	 */
	public void deleteStudentFromBase(int studentId) throws DAOExeption;

	/**
	 * Метод для добавления студента в базу
	 * @param student
	 * @throws DAOExeption
	 */
	public void addStudentToBase(Student student) throws DAOExeption;

}
