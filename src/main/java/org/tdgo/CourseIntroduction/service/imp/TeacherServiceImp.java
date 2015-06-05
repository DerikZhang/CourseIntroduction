package org.tdgo.CourseIntroduction.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.tdgo.CourseIntroduction.dao.TeacherDao;
import org.tdgo.CourseIntroduction.service.TeacherService;

@Repository("teacherService")
public class TeacherServiceImp implements TeacherService {

	@Resource
	TeacherDao teacherDao;
	
	
	
	
}
