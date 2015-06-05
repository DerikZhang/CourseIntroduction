package org.tdgo.CourseIntroduction.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="lesson")
public class Lesson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer lessonID;
	private String name;
	private Double score;
	private String property;
	private Integer academyID;
	private Integer commentTimes;
	private String status;
	private String lessonCode;
	private Integer teacherID;
	
	@Id
	@Column(name="lesson_id",insertable=false,updatable=false)
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	public Integer getLessonID() {
		return lessonID;
	}
	public void setLessonID(Integer lessonID) {
		this.lessonID = lessonID;
	}
	@Column(name="name",length=255,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="score",length=6,nullable=false)
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	@Column(name="property",length=255)
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	@Column(name="academy_id",length=11,nullable=false)
	public Integer getAcademyID() {
		return academyID;
	}
	public void setAcademyID(Integer academyID) {
		this.academyID = academyID;
	}
	@Column(name="comment_times",length=11,nullable=false)
	public Integer getCommentTime() {
		return commentTimes;
	}
	public void setCommentTime(Integer commentTime) {
		this.commentTimes = commentTime;
	}
	@Column(name="status",length=255)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="lesson_code",length=255)
	public String getLessonCode() {
		return lessonCode;
	}
	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}
	@Column(name="teacher_id",length=11,nullable=false)
	public Integer getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}
	
}
