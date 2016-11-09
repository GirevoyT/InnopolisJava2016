package ru.innopolis.server.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Girevoy.T on 07.11.2016.
 */
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "Attendance", schema = "dbo", catalog = "TestBase")
public class AttendanceEntity {
	@EmbeddedId
	@Getter
	@Setter
	private EmbKey key;

	@ManyToOne
	@Getter
	@Setter
	@JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
	private StudentsEntity studentsByStudentId;

	@ManyToOne
	@Getter
	@Setter
	@JoinColumn(name = "lection_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
	private LectionsEntity lectionsByLectionId;


	@EqualsAndHashCode
	@ToString
	@Embeddable
	public static class EmbKey implements Serializable {
		static final long serialVersionUID = 1L;

		@Getter
		@Setter
		@Column(name = "student_id", nullable = false)
		private int studentId;

		@Getter
		@Setter
		@Column(name = "lection_id", nullable = false)
		private int lectionId;
	}
}
