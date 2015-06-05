package org.tdgo.CourseIntroduction.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name= "teacher")
public class Teacher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer teacherID;
	private String name;
	private Double score;
	private Integer academyID;
	private Integer commentTimes;
	
	@Id
	@Column(name="teacher_id",insertable=false,updatable=false)
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	public Integer getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}
	@Column(name="comment_times",length=11,nullable=false)
	public Integer getCommentTimes() {
		return commentTimes;
	}
	public void setCommentTimes(Integer commentTime) {
		this.commentTimes = commentTime;
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
	@Column(name="academy_id",length=11,nullable=false)
	public Integer getAcademyID() {
		return academyID;
	}
	public void setAcademyID(Integer academyID) {
		this.academyID = academyID;
	}
	
}
