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
import org.tdgo.CourseIntroduction.dao.TeacherDao;
import org.tdgo.CourseIntroduction.vo.Result;
import org.tdgo.CourseIntroduction.vo.Teacher;

@Repository("teacherDao")
public class TeacherDaoImp implements TeacherDao {

	
	@Autowired
	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	Session session;
	
	private Logger logger = LoggerFactory.getLogger(TeacherDaoImp.class);
	
	@Override
	public Result addTeacher(Teacher teacher) {
		// TODO add teacher
		Result result = new Result();
		Integer teacherID = null;
		session = sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		try {
			teacherID = (Integer) session.save(teacher);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.ADD_TEACHER_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_TEACHER_ERROR));
		} finally {
			session.close();
		}
		if(teacherID!=null&&teacherID>0){
			result.setErrorCode(ErrorCode.ADD_TEACHER_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_TEACHER_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("teacherID", teacherID);
			result.setParams(params);
		}else{
			result.setErrorCode(ErrorCode.ADD_TEACHER_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_TEACHER_ERROR));
		}

		return result;
	}

	@Override
	public Result updateTeacher(Teacher teacher) {
		// TODO update teacher
		Result result = new Result();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(teacher);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.UPDATE_TEACHER_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.UPDATE_TEACHER_ERROR));
		} finally {
			session.close();
		}
		if(result.getErrorCode()==null){
			result.setErrorCode(ErrorCode.UPDATE_TEACHER_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.UPDATE_TEACHER_OK));
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result deleteTeacher(Teacher teacher) {
		// TODO delete teacher
		Result result = new Result();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			session.delete(teacher);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.DELETE_TEACHER_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.DELETE_TEACHER_ERROR));
		} finally{
			session.close();
		}
		if(result.getErrorCode()==null){
			result.setErrorCode(ErrorCode.DELETE_TEACHER_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.DELETE_TEACHER_OK));
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result getByTID(Integer teacherID) {
		// TODO get teacher by teacher id
		Result result = new Result();
		Teacher teacher = new Teacher();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			teacher = (Teacher) session.get(Teacher.class, teacherID);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_TEACHER_BY_TID_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_TEACHER_BY_TID_ERROR));
		} finally {
			session.close();
		}
		if(teacher.getTeacherID()!=null){
			result.setErrorCode(ErrorCode.GET_TEACHER_BY_TID_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_TEACHER_BY_TID_OK));
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("teacher", teacher);
			result.setParams(params);
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result getByAID(Integer academyID) {
		// TODO get teacher by academy id
		Result result = new Result();
		List<Teacher> teacherList = new ArrayList<Teacher>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Teacher where academy_id = "+ academyID;
			teacherList = session.createQuery(hQLString).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_TEACHER_BY_AID_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_TEACHER_BY_AID_ERROR));
		} finally {
			session.close();
		}
		if(teacherList!=null){
			result.setErrorCode(ErrorCode.GET_TEACHER_BY_AID_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_TEACHER_BY_AID_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("teacherList", teacherList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result getByName(String name,int start) {
		// TODO get teacher by teacher name with start number
		Result result = new Result();
		List<Teacher> teacherList = new ArrayList<Teacher>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Teacher where name like '% "+ name + "%' order by teacher_id DESC ";
			teacherList = session.createQuery(hQLString).setFirstResult(start).setMaxResults(10).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_TEACHER_BY_NAME_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_TEACHER_BY_NAME_ERROR));
		} finally {
			session.close();
		}
		if(teacherList!=null){
			result.setErrorCode(ErrorCode.GET_TEACHER_BY_NAME_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_TEACHER_BY_NAME_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("teacherList", teacherList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result getByName(String name) {
		// TODO get teacher by teacher name without start number
		Result result = new Result();
		List<Teacher> teacherList = new ArrayList<Teacher>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Teacher where name like '% "+ name + "%' order by teacher_id ";
			transaction.commit();
			teacherList = session.createQuery(hQLString).setFirstResult(0).setMaxResults(10).list();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_TEACHER_BY_NAME_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_TEACHER_BY_NAME_ERROR));
		} finally {
			session.close();
		}
		if(teacherList!=null){
			result.setErrorCode(ErrorCode.GET_TEACHER_BY_NAME_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_TEACHER_BY_NAME_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("teacherList", teacherList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}


}
