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
import org.tdgo.CourseIntroduction.dao.OperaterDao;
import org.tdgo.CourseIntroduction.vo.Academy;
import org.tdgo.CourseIntroduction.vo.Operater;
import org.tdgo.CourseIntroduction.vo.Result;


@Repository("operaterDao")
public class OperaterDaoImp implements OperaterDao {

	@Autowired
	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	Session session;
	
	private Logger logger = LoggerFactory.getLogger(OperaterDaoImp.class);
	
	@Override
	public Result getOperaterByUsername(String username) {
		// TODO get operater by username
		Result result = new Result();
		List<Operater> operaterList = new ArrayList<Operater>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hqlString = "from Operater where user_name = '" + username + "'";
			operaterList = session.createQuery(hqlString).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_OPERATER_BY_USERNAME_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_OPERATER_BY_USERNAME_ERROR));
		} finally {
			session.close();
		}
		if(operaterList!=null){
			result.setErrorCode(ErrorCode.GET_OPERATER_BY_USERNAME_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_OPERATER_BY_USERNAME_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("operaterList", operaterList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}
		return result;
	}
	
}
