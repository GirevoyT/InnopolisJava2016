package ru.innopolis.common.models.student;

import ru.innopolis.common.models.student.exeptions.CreateStudentExeption;
import ru.innopolis.common.models.student.exeptions.StudentServiceDataExeption;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Arxan on 31.10.2016.
 */
public interface StudentService {
	public Student createNewStudent(String fistname, String lastname, Sex sex,Date birthDate) throws CreateStudentExeption;
	public ArrayList<Student> getStudentsList() throws StudentServiceDataExeption;
	public ArrayList<Student> getStudentListWithFilterByFirstname(String firstname) throws StudentServiceDataExeption;
	public Student getStudentById (int id) throws StudentServiceDataExeption;
	public void deleteStudentFromBase(Student student) throws StudentServiceDataExeption;
	public void addStudentToBase(Student student) throws StudentServiceDataExeption;
}
