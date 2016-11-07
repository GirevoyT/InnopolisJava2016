package ru.innopolis.server.dao.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Arxan on 07.11.2016.
 */
@Entity
@Table(name = "Lections", schema = "dbo", catalog = "TestBase")
public class LectionsEntity {
	private int id;
	private String topic;
	private String description;
	private int duration;
	private Date date;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "topic", nullable = false, length = 50)
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Basic
	@Column(name = "description", nullable = false, length = 500)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "duration", nullable = false)
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Basic
	@Column(name = "date", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LectionsEntity that = (LectionsEntity) o;

		if (id != that.id) return false;
		if (duration != that.duration) return false;
		if (topic != null ? !topic.equals(that.topic) : that.topic != null) return false;
		if (description != null ? !description.equals(that.description) : that.description != null) return false;
		if (date != null ? !date.equals(that.date) : that.date != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (topic != null ? topic.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + duration;
		result = 31 * result + (date != null ? date.hashCode() : 0);
		return result;
	}
}
