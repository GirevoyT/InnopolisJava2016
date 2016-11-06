package ru.innopolis.common.models.studentXLection;

import ru.innopolis.common.models.student.Student;

import java.util.List;

/**
 * Класс для хранения студента и лекция на которых он был/не был
 */
public class StudentXLection {
	private Student student;
	private List<LectionBox> lectionBox;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public List<LectionBox> getLectionBox() {
		return lectionBox;
	}

	public void setLectionBox(List<LectionBox> lectionBox) {
		this.lectionBox = lectionBox;
	}
}
