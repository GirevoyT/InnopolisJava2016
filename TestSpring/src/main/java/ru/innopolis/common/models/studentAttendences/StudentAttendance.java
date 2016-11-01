package ru.innopolis.common.models.studentAttendences;

import ru.innopolis.common.models.student.Student;

/**
 * Created by Girevoy.T on 01.11.2016.
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
