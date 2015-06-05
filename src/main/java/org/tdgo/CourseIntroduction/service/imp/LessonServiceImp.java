package org.tdgo.CourseIntroduction.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.tdgo.CourseIntroduction.bo.LessonBo;
import org.tdgo.CourseIntroduction.common.ErrorCode;
import org.tdgo.CourseIntroduction.dao.LessonDao;
import org.tdgo.CourseIntroduction.dao.TeacherDao;
import org.tdgo.CourseIntroduction.service.LessonService;
import org.tdgo.CourseIntroduction.vo.Lesson;
import org.tdgo.CourseIntroduction.vo.Result;
import org.tdgo.CourseIntroduction.vo.Teacher;

@Repository("lessonService")
public class LessonServiceImp implements LessonService {

	@Resource
	LessonDao lessonDao;
	
	@Resource
	TeacherDao teacherDao;
	
	Logger logger = LoggerFactory.getLogger(LessonServiceImp.class);
	
	@Override
	public Result getLessonBoInfo(Lesson lesson){
		Result result = new Result();
		Map<String, Object> params = new HashMap<String, Object>();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		List<Teacher> teacherList = new ArrayList<Teacher>();
		List<LessonBo> lessonBoList = new ArrayList<LessonBo>();
		
		if(lesson.getLessonID()==null||lesson.getLessonID()==0){
			result.setErrorCode(ErrorCode.LESSON_ID_NULL);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.LESSON_ID_NULL));
			logger.debug(result.getMessage()+"in Service");
		}else{
			result = lessonDao.getByLID(lesson.getLessonID());
			if(result.getErrorCode()==ErrorCode.GET_LESSON_BY_LID_OK){
				lesson = (Lesson) result.getParams().get("lesson");
				Result lsnResult = lessonDao.getByName(lesson.getName());
				if(lsnResult.getErrorCode()==ErrorCode.GET_LESSON_BY_NAME_OK){
					lessonList = (List<Lesson>) lsnResult.getParams().get("lessonList");
					for (Lesson lesson2 : lessonList) {
						LessonBo lessonBo = new LessonBo();
						lessonBo.setLessonId(lesson2.getLessonID());
						lessonBo.setLessonCode(lesson2.getLessonCode());
						lessonBo.setLessonName(lesson2.getName());
						lessonBo.setScore(lesson2.getScore());
						lessonBo.setTeacherId(lesson2.getTeacherID());
						Result tchResult = teacherDao.getByTID(lesson2.getTeacherID()); 
						if(tchResult.getErrorCode()==ErrorCode.GET_TEACHER_BY_TID_OK){
							Teacher teacher = (Teacher) tchResult.getParams().get("teacher");
							lessonBo.setTeacherName(teacher.getName());
						}
						lessonBoList.add(lessonBo);
					}
					result.setErrorCode(ErrorCode.GET_LESSONBO_INFO_OK);
					result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSONBO_INFO_OK));
					logger.debug(result.getMessage());
					params.put("lessonBoList", lessonBoList);
					result.setParams(params);
				}
			}
		}		
		if(result.getErrorCode()!=ErrorCode.GET_LESSONBO_INFO_OK){
			result.setErrorCode(ErrorCode.GET_LESSONBO_INFO_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSONBO_INFO_ERROR));
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result getLessonBoByID(Lesson lesson) {
		Result result = new Result();
		LessonBo lessonBo = new LessonBo();
		Map<String, Object> map =new HashMap<String, Object>();
		if(lesson.getLessonID()==null||lesson.getLessonID()==0){
			result.setErrorCode(ErrorCode.LESSON_ID_NULL);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.LESSON_ID_NULL));
			logger.debug(result.getMessage()+"in"+this.toString());
		}else{
			result = lessonDao.getByLID(lesson.getLessonID());
			if(result.getErrorCode()==ErrorCode.GET_LESSON_BY_LID_OK){
				lesson = (Lesson) result.getParams().get("lesson");
				lessonBo.setLessonId(lesson.getLessonID());
				lessonBo.setLessonCode(lesson.getLessonCode());
				lessonBo.setLessonName(lesson.getName());
				lessonBo.setScore(lesson.getScore());
				lessonBo.setTeacherId(lesson.getTeacherID());
				Result tchResult = teacherDao.getByTID(lesson.getTeacherID());
				if(tchResult.getErrorCode()==ErrorCode.GET_TEACHER_BY_TID_OK){
					Teacher teacher = (Teacher) tchResult.getParams().get("teacher");
					lessonBo.setTeacherName(teacher.getName());
				}
				map.put("lessonBo", lessonBo);
				result.setErrorCode(ErrorCode.GET_LESSONBO_BY_ID_OK);
				result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSONBO_BY_ID_OK));
				logger.debug(result.getMessage());
			}
			result.setParams(map);
		}
		return result;
	}

	@Override
	public Result getLessonBoForHome() {
		// TODO get lessonBo for home page
		Result result = new Result();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		List<LessonBo> lessonBoList = new ArrayList<LessonBo>();
		Map<String, Object> map =new HashMap<String, Object>();
			result = lessonDao.getByStatus("home",0);
			if(result.getErrorCode()==ErrorCode.GET_LESSON_BY£ßSTATUS_OK){
				lessonList = (List<Lesson>) result.getParams().get("lessonList");
				for (Lesson lesson : lessonList) {
					LessonBo lessonBo = new LessonBo();
					lessonBo.setLessonId(lesson.getLessonID());
					lessonBo.setLessonCode(lesson.getLessonCode());
					lessonBo.setLessonName(lesson.getName());
					lessonBo.setScore(lesson.getScore());
					lessonBo.setTeacherId(lesson.getTeacherID());
					Result tchResult = teacherDao.getByTID(lesson.getTeacherID());
					if(tchResult.getErrorCode()==ErrorCode.GET_TEACHER_BY_TID_OK){
						Teacher teacher = (Teacher) tchResult.getParams().get("teacher");
						lessonBo.setTeacherName(teacher.getName());
					}
					lessonBoList.add(lessonBo);
				}
				map.put("lessonBoList", lessonBoList);
				result.setErrorCode(ErrorCode.GET_LESSONBO_FOR£ßHOME_OK);
				result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSONBO_FOR£ßHOME_OK));
				logger.info(result.getMessage());
			}else{
				result.setErrorCode(ErrorCode.GET_LESSONBO_FOR£ßHOME_ERROR);
				result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSONBO_FOR£ßHOME_ERROR));
				logger.error(result.getMessage());
			}
			result.setParams(map);
			
		return result;
	}
	
}
