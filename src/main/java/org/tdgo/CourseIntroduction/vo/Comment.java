package org.tdgo.CourseIntroduction.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="comment")
public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer commentID;
	private String commentCode;
	private Integer lessonID;
	private Integer teacherID;
	private Integer good;
	private String writeTime;
	private Double score;
	private String comment;
	
	@Id
	@Column(name="comment_id",insertable=false,updatable=false)
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	public Integer getCommentID() {
		return commentID;
	}
	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}
	@Column(name="comment_code",length=255,nullable=false)
	public String getCommentCode() {
		return commentCode;
	}
	public void setCommentCode(String commentCode) {
		this.commentCode = commentCode;
	}
	@Column(name="lesson_id",length=11)
	public Integer getLessonID() {
		return lessonID;
	}
	public void setLessonID(Integer lessonID) {
		this.lessonID = lessonID;
	}
	@Column(name="teacher_id",length=11)
	public Integer getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}
	@Column(name="good",length=11,nullable=false)
	public Integer getGood() {
		return good;
	}
	public void setGood(Integer good) {
		this.good = good;
	}
	@Column(name="write_time",length=255,nullable=false)
	public String getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}
	@Column(name="score",length=6,nullable=false)
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	@Column(name="comment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
