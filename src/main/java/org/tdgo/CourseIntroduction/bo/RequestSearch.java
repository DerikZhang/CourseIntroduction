package org.tdgo.CourseIntroduction.bo;

import java.io.Serializable;

public class RequestSearch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int page;
	private int modelFlag;
	private String teacherName;
	private String lessonName;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getModelFlag() {
		return modelFlag;
	}
	public void setModelFlag(int modelFlag) {
		this.modelFlag = modelFlag;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	
}
