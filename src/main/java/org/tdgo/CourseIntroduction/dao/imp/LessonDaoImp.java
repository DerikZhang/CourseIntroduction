package org.tdgo.CourseIntroduction.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tdgo.CourseIntroduction.common.ErrorCode;
import org.tdgo.CourseIntroduction.dao.LessonDao;
import org.tdgo.CourseIntroduction.util.CommonFunction;
import org.tdgo.CourseIntroduction.vo.Academy;
import org.tdgo.CourseIntroduction.vo.Lesson;
import org.tdgo.CourseIntroduction.vo.Result;

@Repository("lessonDao")
public class LessonDaoImp implements LessonDao {

	@Autowired
	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	Session session;

	private Logger logger = LoggerFactory.getLogger(LessonDaoImp.class);

	@Override
	public Result addLesson(Lesson lesson) {
		// TODO add lesson
		Result result = new Result();
		lesson.setLessonCode(CommonFunction.getCommentCode());
		Integer lessonID = null;
		session = sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		try {
			lessonID = (Integer) session.save(lesson);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.ADD_LESSON_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_LESSON_ERROR));
		} finally {
			session.close();
		}
		if(lessonID!=null&&lessonID>0){
			result.setErrorCode(ErrorCode.ADD_LESSON_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_LESSON_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("lessonID", lessonID);
			result.setParams(params);
		}else{
			result.setErrorCode(ErrorCode.ADD_LESSON_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_LESSON_ERROR));
		}

		return result;
	}

	@Override
	public Result updateLesson(Lesson lesson) {
		// TODO update lesson
		Result result = new Result();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(lesson);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.UPDATE_LESSON_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.UPDATE_LESSON_ERROR));
		} finally {
			session.close();
		}
		if(result.getErrorCode()==null){
			result.setErrorCode(ErrorCode.UPDATE_LESSON_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.UPDATE_LESSON_OK));
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result deleteLesson(Lesson lesson) {
		// TODO delete lesson
		Result result = new Result();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			session.delete(lesson);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.DELETE_LESSON_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.DELETE_LESSON_ERROR));
		} finally{
			session.close();
		}
		if(result.getErrorCode()==null){
			result.setErrorCode(ErrorCode.DELETE_LESSON_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.DELETE_LESSON_OK));
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result getByLID(Integer lessonID) {
		// TODO get lesson By lesson id
		Result result = new Result();
		Lesson lesson = new Lesson();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			lesson = (Lesson) session.get(Lesson.class, lessonID);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_LESSON_BY_LID_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_LID_ERROR));
		} finally {
			session.close();
		}
		if(lesson.getLessonID()!=null){
			result.setErrorCode(ErrorCode.GET_LESSON_BY_LID_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_LID_OK));
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("lesson", lesson);
			result.setParams(params);
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result getByTID(Integer teacherID) {
		// TODO get lesson By teacher id
		Result result = new Result();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Lesson where teacher_id = "+ teacherID;
			lessonList = session.createQuery(hQLString).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_LESSON_BY_TID_ERROR);
			result.setErrorCode(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_TID_ERROR));
		} finally {
			session.close();
		}
		if(lessonList!=null){
			result.setErrorCode(ErrorCode.GET_LESSON_BY_TID_OK);
			result.setErrorCode(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_TID_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("lessonList", lessonList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result getByAID(Integer academyID) {
		// TODO get lesson by academy id
		Result result = new Result();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Lesson where academy_id = "+ academyID;
			lessonList = session.createQuery(hQLString).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_LESSON_BY_AID_ERROR);
			result.setErrorCode(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_AID_ERROR));
		} finally {
			session.close();
		}
		if(lessonList!=null){
			result.setErrorCode(ErrorCode.GET_LESSON_BY_AID_OK);
			result.setErrorCode(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_AID_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("lessonList", lessonList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result getByProperty(String property,int start) {
		// TODO get lesson by property
		Result result = new Result();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Lesson where property like '% "+ property + "%'";
			lessonList = session.createQuery(hQLString).setFirstResult(start).setMaxResults(10).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_LESSON_BY_PROPERTY_ERROR);
			result.setErrorCode(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_PROPERTY_ERROR));
		} finally {
			session.close();
		}
		if(lessonList!=null){
			result.setErrorCode(ErrorCode.GET_LESSON_BY_PROPERTY_OK);
			result.setErrorCode(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_PROPERTY_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("lessonList", lessonList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result getSearchByScore(int start,String order) {
		// TODO get lesson after searching lesson and order by Score with start number
		Result result = new Result();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = "from Lesson order by score " + order;
			lessonList = session.createQuery(hQLString).setFirstResult(start).setMaxResults(10).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_LESSON_BY_SEARCH_SCORE_ERROR);
			result.setErrorCode(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_SEARCH_SCORE_ERROR));
		} finally {
			session.close();
		}
		if(lessonList!=null){
			result.setErrorCode(ErrorCode.GET_LESSON_BY_SEARCH_SCORE_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_SEARCH_SCORE_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("lessonList", lessonList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result getSearchByComment(int start,String order) {
		// TODO get lesson order by comment times
		Result result = new Result();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Lesson order by comment_times "+order;
			lessonList = session.createQuery(hQLString).setFirstResult(start).setMaxResults(10).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_LESSON_BY_SEARCH_COMMENT_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_SEARCH_COMMENT_ERROR));
		} finally {
			session.close();
		}
		if(lessonList!=null){
			result.setErrorCode(ErrorCode.GET_LESSON_BY_SEARCH_COMMENT_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_SEARCH_COMMENT_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("lessonList", lessonList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result getByName(String name) {
		// TODO get lesson by lesson name
		Result result = new Result();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Lesson where name =  '"+ name + "'";
			lessonList = session.createQuery(hQLString).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_LESSON_BY_NAME_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_NAME_ERROR));
		} finally {
			session.close();
		}
		if(lessonList!=null){
			result.setErrorCode(ErrorCode.GET_LESSON_BY_NAME_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_NAME_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("lessonList", lessonList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}
	
	@Override
	public Result getSearchByVague(String name,int start) {
		// TODO get lesson after searching a vague word with start nnumber
		Result result = new Result();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Lesson where name like '% "+ name +"%' "
					+ "OR  teacher_id IN (select teacher_id from Teacher teacher_id where name like '%" + name + "%')"
							+ " order by score ";
			lessonList = session.createQuery(hQLString).setFirstResult(start).setMaxResults(10).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_LESSON_BY_VAGUE_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_VAGUE_ERROR));
		} finally {
			session.close();
		}
		if(lessonList!=null){
			result.setErrorCode(ErrorCode.GET_LESSON_BY_VAGUE_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_VAGUE_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("lessonList", lessonList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result getByStatus(String status,Integer start) {
		// TODO get lesson by status
		Result result =new Result();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Lesson> lessonList = new ArrayList<Lesson>();
		try {
			String hQLString = "from Lesson where status like '%" + status + "%'";
			lessonList = session.createQuery(hQLString).setFirstResult(start).setMaxResults(10).list();
			transaction.commit();
		} catch (Exception e) {
			// TODO: exception logger
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_LESSON_BY£ßSTATUS_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY£ßSTATUS_ERROR));
		}finally{
			session.close();
		}
		if(result.getErrorCode()==null){
			result.setErrorCode(ErrorCode.GET_LESSON_BY£ßSTATUS_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY£ßSTATUS_OK));
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("lessonList", lessonList);
			result.setParams(params);
		}
		return result;
	}

}
