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
import org.tdgo.CourseIntroduction.dao.AcademyDao;
import org.tdgo.CourseIntroduction.vo.Academy;
import org.tdgo.CourseIntroduction.vo.Result;

@Repository("academyDao")
public class AcademyDaoImp implements AcademyDao {

	@Autowired
	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	Session session;
	
	private Logger logger = LoggerFactory.getLogger(AcademyDaoImp.class);
	
	@Override
	public Result addAcademy(Academy academy) {
		// TODO Add academy
		Result result = new Result();
		Integer academyId = null;
		session = sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		try {
			academyId = (Integer) session.save(academy);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.ADD_ACADEMY_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_ACADEMY_ERROR));
		} finally {
			session.close();
		}
		if(academyId!=null&&academyId>0){
			result.setErrorCode(ErrorCode.ADD_ACADEMY_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_ACADEMY_OK));
			logger.debug(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_ACADEMY_OK));
		}else{
			result.setErrorCode(ErrorCode.ADD_ACADEMY_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_ACADEMY_ERROR));
			logger.debug(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_ACADEMY_ERROR));
		}
		return result;
	}

	@Override
	public Result updateAcademy(Academy academy) {
		// TODO update academy
		Result result = new Result();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(academy);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.UPDATE_ACADEMY_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.UPDATE_ACADEMY_ERROR));
		} finally {
			session.close();
		}
		if(result.getErrorCode()==null){
			result.setErrorCode(ErrorCode.UPDATE_ACADEMY_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.UPDATE_ACADEMY_OK));
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result deleteAcademy(Academy academy) {
		// TODO delete academy
		Result result = new Result();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			session.delete(academy);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.DELETE_ACADEMY_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.DELETE_ACADEMY_ERROR));
		} finally{
			session.close();
		}
		if(result.getErrorCode()==null){
			result.setErrorCode(ErrorCode.DELETE_ACADEMY_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.DELETE_ACADEMY_OK));
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result getByAID(Integer academyID) {
		// TODO get academy by academy id
		Result result = new Result();
		Academy academy = new Academy();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			academy = (Academy) session.get(Academy.class, academyID);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_ACADEMY_BY_AID_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_ACADEMY_BY_AID_ERROR));
		} finally {
			session.close();
		}
		if(academy.getAcademyID()!=null){
			result.setErrorCode(ErrorCode.GET_ACADEMY_BY_AID_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_ACADEMY_BY_AID_OK));
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("academy", academy);
			result.setParams(params);
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result getByName(String name , int start) {
		// TODO get academy by academy name with start number
		Result result = new Result();
		List<Academy> academyList = new ArrayList<Academy>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = "from Academy where name like '%"+ name + "%'";
			academyList = session.createQuery(hQLString).setFirstResult(start).setMaxResults(10).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_ACADEMY_BY_NAME_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_ACADEMY_BY_NAME_ERROR));
		} finally {
			session.close();
		}
		if(academyList!=null){
			result.setErrorCode(ErrorCode.GET_ACADEMY_BY_NAME_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_ACADEMY_BY_NAME_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("academyList", academyList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}
		
		return result;
	}
	
	@Override
	public Result getByName(String name ) {
		// TODO get academy by academy name without start number
		Result result = new Result();
		List<Academy> academyList = new ArrayList<Academy>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = "from Academy where name like '%"+ name + "%' ";
			academyList = session.createQuery(hQLString).setFirstResult(0).setMaxResults(10).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_ACADEMY_BY_NAME_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_ACADEMY_BY_NAME_ERROR));
		} finally {
			session.close();
		}
		if(academyList!=null){
			result.setErrorCode(ErrorCode.GET_ACADEMY_BY_NAME_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_ACADEMY_BY_NAME_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("academyList", academyList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}
		
		return result;
	}

}
