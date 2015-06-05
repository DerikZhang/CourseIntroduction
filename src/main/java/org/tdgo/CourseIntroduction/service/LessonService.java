package org.tdgo.CourseIntroduction.service;

import org.tdgo.CourseIntroduction.vo.Lesson;
import org.tdgo.CourseIntroduction.vo.Result;

public interface LessonService {

	public Result getLessonBoInfo(Lesson lesson);

	public Result getLessonBoByID(Lesson lesson);
	
	public Result getLessonBoForHome();
}
