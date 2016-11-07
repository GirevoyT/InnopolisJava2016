package ru.innopolis.server.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Girevoy.T on 07.11.2016.
 */
@Entity
@Table(name = "Attendance", schema = "dbo", catalog = "TestBase")
@IdClass(AttendanceEntity.EmbKey.class)
public class AttendanceEntity {
	private int studentId;
	private int lectionId;
	private StudentsEntity studentsByStudentId;
	private LectionsEntity lectionsByLectionId;


	@Id
	@Column(name = "student_id", nullable = false)
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	@Id
	@Column(name = "lection_id", nullable = false)
	public int getLectionId() {
		return lectionId;
	}

	public void setLectionId(int lectionId) {
		this.lectionId = lectionId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AttendanceEntity that = (AttendanceEntity) o;

		if (studentId != that.studentId) return false;
		if (lectionId != that.lectionId) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = studentId;
		result = 31 * result + lectionId;
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
	public StudentsEntity getStudentsByStudentId() {
		return studentsByStudentId;
	}

	public void setStudentsByStudentId(StudentsEntity studentsByStudentId) {
		this.studentsByStudentId = studentsByStudentId;
	}

	@ManyToOne
	@JoinColumn(name = "lection_id", referencedColumnName = "id", nullable = false)
	public LectionsEntity getLectionsByLectionId() {
		return lectionsByLectionId;
	}

	public void setLectionsByLectionId(LectionsEntity lectionsByLectionId) {
		this.lectionsByLectionId = lectionsByLectionId;
	}


	public static class EmbKey implements Serializable {
		static final long serialVersionUID = 1L;

		private int studentId;
		private int lectionId;

		public EmbKey(){};

		@Column(name = "student_id", nullable = false,insertable = false,updatable = false)
		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}


		@Column(name = "lection_id", nullable = false,insertable = false,updatable = false)
		public int getLectionId() {
			return lectionId;
		}

		public void setLectionId(int lectionId) {
			this.lectionId = lectionId;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			EmbKey embKey = (EmbKey) o;

			if (studentId != embKey.studentId) return false;
			return lectionId == embKey.lectionId;

		}

		@Override
		public int hashCode() {
			int result = studentId;
			result = 31 * result + lectionId;
			return result;
		}

		@Override
		public String toString() {
			return "EmbKey{" +
				"studentId=" + studentId +
				", lectionId=" + lectionId +
				'}';
		}
	}
}
