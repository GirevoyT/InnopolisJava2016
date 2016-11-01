package ru.innopolis.server.dao.student;

import ru.innopolis.common.models.student.Student;
import ru.innopolis.server.dao.student.exeptions.DAOExeption;

import java.util.ArrayList;

/**
 * Created by Arxan on 31.10.2016.
 */

public interface DAOStudent {
	public ArrayList<Student> getStudentsList() throws DAOExeption;
	public ArrayList<Student> getStudentListWithFilterByFirstname(String firstname) throws DAOExeption;
	public Student getStudentById(int id) throws DAOExeption;
	public void deleteStudentFromBase(int studentId) throws DAOExeption;
	public void addStudentToBase(Student student) throws DAOExeption;

}
