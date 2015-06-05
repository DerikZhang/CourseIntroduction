package org.tdgo.CourseIntroduction.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.tdgo.CourseIntroduction.common.ErrorCode;
import org.tdgo.CourseIntroduction.dao.OperaterDao;
import org.tdgo.CourseIntroduction.dao.imp.OperaterDaoImp;
import org.tdgo.CourseIntroduction.service.OperatService;
import org.tdgo.CourseIntroduction.vo.Operater;
import org.tdgo.CourseIntroduction.vo.Result;

@Repository("operatService")
public class OperatServiceImp implements OperatService {

	@Resource
	OperaterDao operaterDao;

	private Logger logger = LoggerFactory.getLogger(OperatServiceImp.class);
	
	@Override
	public Result login(Operater operater) {
		// TODO login into back system
		Result result = new Result();
		List<Operater> operaterList = new ArrayList<Operater>();
		Map<String, Object> params = new HashMap<String, Object>();
		Operater getOperater = new Operater();
		result = operaterDao.getOperaterByUsername(operater.getUserName());
		if(result.getErrorCode()!=ErrorCode.GET_OPERATER_BY_USERNAME_OK){
			operaterList = (List<Operater>) result.getParams().get("operaterList");
			getOperater = operaterList.get(0);
			if(getOperater==null){
				logger.debug("operater didn't exist!");
				result.setErrorCode(ErrorCode.USERNAME_NOT_EXIST);
				result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.USERNAME_NOT_EXIST));
			}//verify password
			else if(getOperater.getPassword()!=operater.getPassword()){
				logger.debug("operater "+ operater.getUserName()+" password wrong!");
				result.setErrorCode(ErrorCode.LOGIN_IN_SERVICE_PASSWORD_WRONG);
				result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.LOGIN_IN_SERVICE_PASSWORD_WRONG));
			}else{
				logger.debug("operater "+ operater.getUserName()+" success");
				result.setErrorCode(ErrorCode.LOGIN_IN_SERVICE_OK);
				result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.LOGIN_IN_SERVICE_OK));
				params.put("operater", getOperater);
				result.setParams(params);
			}
		}
		return result;
	}

}
