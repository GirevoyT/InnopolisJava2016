package ru.innopolis.common.models.studentAttendences;

import ru.innopolis.common.models.student.Student;

/**
 * Класс для хранения студента и количеств посещеных им лекций
 */
public class StudentAttendance {
	private Student student;
	private int lectionCount;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getLectionCount() {
		return lectionCount;
	}

	public void setLectionCount(int lectionCount) {
		this.lectionCount = lectionCount;
	}
}
