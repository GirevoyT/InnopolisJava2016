package ru.innopolis.common.models.student;

import ru.innopolis.common.models.student.exeptions.CreateStudentExeption;
import ru.innopolis.common.models.student.exeptions.StudentServiceDataExeption;

import java.util.ArrayList;
import java.util.Date;

/**
 * Интерфейс сервисов модели студента
 */
public interface StudentService {
	/**
	 * Метод для создания экземпляра студента с определёнными полями
	 * @param fistname имя
	 * @param lastname фамилия
	 * @param sex пол
	 * @param birthDate дата рождения
	 * @return экземпляр класса Student
	 * @throws CreateStudentExeption
	 */
	public Student createNewStudent(String fistname, String lastname, Sex sex,Date birthDate) throws CreateStudentExeption;

	/**
	 * Мето для получения списка студентов
	 * @return Список студентов
	 * @throws StudentServiceDataExeption
	 */
	public ArrayList<Student> getStudentsList() throws StudentServiceDataExeption;

	/**
	 * Метод для получения списка студентов с заданным именем
	 * @param firstname имя
	 * @return Список студенртов
	 * @throws StudentServiceDataExeption
	 */
	public ArrayList<Student> getStudentListWithFilterByFirstname(String firstname) throws StudentServiceDataExeption;

	/**
	 * Метод для получения студента с указаным id
	 * @param id id студента
	 * @return Экземпляр студента
	 * @throws StudentServiceDataExeption
	 */
	public Student getStudentById (int id) throws StudentServiceDataExeption;

	/**
	 * Метод для удаление студента из базы
	 * @param student экземпляр студента
	 * @throws StudentServiceDataExeption
	 */
	public void deleteStudentFromBase(Student student) throws StudentServiceDataExeption;

	/**
	 * Метод для удаления студента из базы по id
	 * @param id id студента
	 * @throws StudentServiceDataExeption
	 */
	public void deleteStudentFromBaseById(int id) throws StudentServiceDataExeption;

	/**
	 * Метод для добавления студента в базу
	 * @param student экземпляр студента
	 * @throws StudentServiceDataExeption
	 */
	public void addStudentToBase(Student student) throws StudentServiceDataExeption;
}
