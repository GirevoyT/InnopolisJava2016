package ru.innopolis.common.models.attendance;

/**
 * Класс для хранения посещения студентом studentId лекции lectionId
 */
public class Attendance {

	private int studentId;
	private int lectionId;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getLectionId() {
		return lectionId;
	}

	public void setLectionId(int lectionId) {
		this.lectionId = lectionId;
	}

}
