package org.tdgo.CourseIntroduction.service.imp;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.tdgo.CourseIntroduction.bo.LessonBo;
import org.tdgo.CourseIntroduction.bo.RequestSearch;
import org.tdgo.CourseIntroduction.common.Config;
import org.tdgo.CourseIntroduction.common.ErrorCode;
import org.tdgo.CourseIntroduction.dao.CommentDao;
import org.tdgo.CourseIntroduction.dao.LessonDao;
import org.tdgo.CourseIntroduction.dao.TeacherDao;
import org.tdgo.CourseIntroduction.service.SearchService;
import org.tdgo.CourseIntroduction.vo.Lesson;
import org.tdgo.CourseIntroduction.vo.Result;
import org.tdgo.CourseIntroduction.vo.Teacher;

@Repository("searchService")
public class SearchServiceImp implements SearchService {

	@Resource
	CommentDao commentDao;
	
	@Resource
	LessonDao lessonDao;
	
	@Resource
	TeacherDao teacherDao;

	private Logger logger = LoggerFactory.getLogger(SearchService.class);

	/*
	 * (non-Javadoc)
	 * @see org.tdgo.CourseIntroduction.service.SearchService#getScoreLesson(java.util.Map)
	 * @Description: requestMap:{int page,int ModelFlag}
	 */
	@Override
	public Result getScoreLesson(RequestSearch requestSearch) {
		// TODO get lesson by score status
		String order = null;
		int start = ((Integer)requestSearch.getPage()-1)*10;
		Map<String, Object> params = new HashMap<String, Object>();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		List<LessonBo> lessonBoList = new ArrayList<LessonBo>();
		if((Integer)requestSearch.getModelFlag()==Config.HIGHER_SCORE_LIST){
			order = "DESC";
		}else if((Integer)requestSearch.getModelFlag()==Config.LOW_SCORE_LIST){
			order = "ASC";
		}
		//get high score list
		Result result = lessonDao.getSearchByScore(start,order);
		if(result.getErrorCode()==ErrorCode.GET_LESSON_BY_SEARCH_SCORE_OK){
			lessonList = (List<Lesson>) result.getParams().get("lessonList");
			for (Lesson lesson : lessonList) {
				Result tchResult = teacherDao.getByTID(lesson.getTeacherID());
				LessonBo lessonBo =  new LessonBo();
				if(tchResult.getErrorCode()==ErrorCode.GET_TEACHER_BY_TID_OK){
					Teacher teacher = (Teacher)tchResult.getParams().get("teacher");
					lessonBo.setTeacherId(teacher.getTeacherID());
					lessonBo.setTeacherName(teacher.getName());
				}
				lessonBo.setLessonCode(lesson.getLessonCode());
				lessonBo.setLessonName(lesson.getName());
				lessonBo.setScore(lesson.getScore());
				lessonBo.setLessonId(lesson.getLessonID());
				lessonBoList.add(lessonBo);
			}
			params.put("lessonBoList", lessonBoList);
			result.setParams(params);
			result.setErrorCode(ErrorCode.GET_SCORE_LESSON_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_SCORE_LESSON_OK));
			logger.info(result.getMessage()+"in Search Service");
		}else{
			result.setErrorCode(ErrorCode.GET_SCORE_LESSON_ERROR);
			logger.error(result.getMessage()+"in Search Service");
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_SCORE_LESSON_ERROR));
			result.setParams(null);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see org.tdgo.CourseIntroduction.service.SearchService#getCommentLesson(java.util.Map)
	 * @Description: requestMap:{int page,int ModelFlag}
	 */
	@Override
	public Result getCommentLesson(RequestSearch requestSearch) {
		// TODO get the comment by lesson id
		String order = "DESC";
		Result result = new Result();
		int start = ((Integer)requestSearch.getPage()-1)*10;
		Map<String, Object> params = new HashMap<String, Object>();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		List<LessonBo> lessonBoList = new ArrayList<LessonBo>();
		result = lessonDao.getSearchByComment(start, order);
		if(result.getErrorCode()==ErrorCode.GET_LESSON_BY_SEARCH_COMMENT_OK){
			lessonList = (List<Lesson>) result.getParams().get("lessonList");
			for (Lesson lesson : lessonList) {
				Result tchResult = teacherDao.getByTID(lesson.getTeacherID());
				LessonBo lessonBo =  new LessonBo();
				if(tchResult.getErrorCode()==ErrorCode.GET_TEACHER_BY_TID_OK){
					Teacher teacher = (Teacher)tchResult.getParams().get("teacher");
					lessonBo.setTeacherId(teacher.getTeacherID());
					lessonBo.setTeacherName(teacher.getName());
				}
				lessonBo.setLessonCode(lesson.getLessonCode());
				lessonBo.setLessonName(lesson.getName());
				lessonBo.setScore(lesson.getScore());
				lessonBo.setLessonId(lesson.getLessonID());
				lessonBoList.add(lessonBo);
			}
			params.put("lessonBoList", lessonBoList);
			result.setParams(params);
			result.setErrorCode(ErrorCode.GET_COMMENT_LESSON_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_LESSON_OK));
			logger.info(result.getMessage()+"in Search Service");
		}else{
			result.setErrorCode(ErrorCode.GET_COMMENT_LESSON_ERROR);
			logger.error(result.getMessage()+"in Search Service");
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_LESSON_ERROR));
			result.setParams(null);
		}
		return result;
	}

	@Override
	public Result vagueSearchLesson(RequestSearch requestReaSearch) {
		// TODO vague search lesson 
		Result result = new Result();
		int start = (requestReaSearch.getPage()-1)*10;
		Map<String, Object> params = new HashMap<String, Object>();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		List<LessonBo> lessonBoList = new ArrayList<LessonBo>();
		
		result = lessonDao.getSearchByVague(requestReaSearch.getLessonName(),start);
		if(result.getErrorCode()==ErrorCode.GET_LESSON_BY_VAGUE_OK){
			lessonList = (List<Lesson>) result.getParams().get("lessonList");
			for (Lesson lesson : lessonList) {
				Result tchResult = teacherDao.getByTID(lesson.getTeacherID());
				LessonBo lessonBo =  new LessonBo();
				if(tchResult.getErrorCode()==ErrorCode.GET_TEACHER_BY_TID_OK){
					Teacher teacher = (Teacher)tchResult.getParams().get("teacher");
					lessonBo.setTeacherId(teacher.getTeacherID());
					lessonBo.setTeacherName(teacher.getName());
				}
				lessonBo.setLessonCode(lesson.getLessonCode());
				lessonBo.setLessonName(lesson.getName());
				lessonBo.setLessonId(lesson.getLessonID());
				lessonBo.setScore(lesson.getScore());
				lessonBoList.add(lessonBo);
			}
			params.put("lessonBoList", lessonBoList);
			result.setParams(params);
			result.setErrorCode(ErrorCode.GET_VAGUE_LESSON_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_VAGUE_LESSON_OK));
			logger.info(result.getMessage()+"in Search Service");
		}else{
			result.setErrorCode(ErrorCode.GET_VAGUE_LESSON_ERROR);
			logger.error(result.getMessage()+"in Search Service");
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_VAGUE_LESSON_ERROR));
			result.setParams(null);
		}
		return result;
	}


	

}
