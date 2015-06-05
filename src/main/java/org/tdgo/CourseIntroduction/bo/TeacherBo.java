package org.tdgo.CourseIntroduction.bo;

import java.io.Serializable;

public class TeacherBo implements Serializable {

	private String teacherName;
	private Integer teacherId;
	
	
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
	
	
	
}
