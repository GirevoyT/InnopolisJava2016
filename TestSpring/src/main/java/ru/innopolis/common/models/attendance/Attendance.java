package ru.innopolis.common.models.attendance;

/**
 * Класс для хранения посещения студентом student_id лекции lection_id
 */
public class Attendance {

	private int student_id;
	private int lection_id;

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getLection_id() {
		return lection_id;
	}

	public void setLection_id(int lection_id) {
		this.lection_id = lection_id;
	}

}
