package org.tdgo.CourseIntroduction.bo;

import java.io.Serializable;
import java.util.List;

import org.tdgo.CourseIntroduction.vo.Lesson;

public class LessonBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String lessonCode;
	private String lessonName;
	private Double score;
	private Integer lessonId;
	private Integer teacherId;
	private String teacherName;
	
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getLessonId() {
		return lessonId;
	}
	public void setLessonId(Integer lesson_id) {
		this.lessonId = lesson_id;
	}
	public String getLessonCode() {
		return lessonCode;
	}
	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	
	
	
}
