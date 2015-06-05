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
import org.tdgo.CourseIntroduction.dao.CommentDao;
import org.tdgo.CourseIntroduction.vo.Comment;
import org.tdgo.CourseIntroduction.vo.Result;


@Repository("commentDao")
public class CommentDaoImp implements CommentDao{


	@Autowired
	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	Session session;
	
	private Logger logger = LoggerFactory.getLogger(CommentDaoImp.class);
	
	@Override
	public Result addComment(Comment comment) {
		// TODO add comment 
		Result result = new Result();
		Integer commentID = null;
		session = sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		try {
			commentID = (Integer) session.save(comment);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.ADD_COMMENT_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_COMMENT_ERROR));
		} finally {
			session.close();
		}
		if(commentID!=null&&commentID>0){
			result.setErrorCode(ErrorCode.ADD_COMMENT_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_COMMENT_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("commentID", commentID);
			result.setParams(params);
		}else{
			result.setErrorCode(ErrorCode.ADD_COMMENT_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_COMMENT_ERROR));
		}

		return result;
	}

	@Override
	public Result deleteComment(Comment comment) {
		// TODO update comment
		Result result = new Result();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			session.delete(comment);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.DELETE_COMMENT_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.DELETE_COMMENT_ERROR));
		} finally{
			session.close();
		}
		if(result.getErrorCode()==null){
			result.setErrorCode(ErrorCode.DELETE_COMMENT_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.DELETE_COMMENT_OK));
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result getByCID(Integer commentID) {
		// TODO get comment by Comment ID
		Result result = new Result();
		Comment comment = new Comment();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			comment = (Comment) session.get(Comment.class, commentID);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_CID_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_CID_ERROR));
		} finally {
			session.close();
		}
		if(comment.getCommentID()!=null){
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_CID_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_CID_OK));
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("comment", comment);
			result.setParams(params);
			logger.debug(result.getMessage());
		}
		return result;
	}

	@Override
	public Result getByLID(Integer lessonID,Integer start) {
		// TODO get comment by lesson id
		Result result = new Result();
		List<Comment> commentList = new ArrayList<Comment>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Comment where lesson_id = "+ lessonID +"order by good DESC";
			commentList = session.createQuery(hQLString).setFirstResult(start).setMaxResults(10).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_LID_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_LID_ERROR));
		} finally {
			session.close();
		}
		if(commentList!=null){
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_LID_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_LID_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("commentList", commentList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result getByTID(Integer teacherID) {
		// TODO get comment by teacher id
		Result result = new Result();
		List<Comment> commentList = new ArrayList<Comment>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Comment where teacher_id = "+ teacherID;
			commentList = session.createQuery(hQLString).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_TID_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_TID_ERROR));
		} finally {
			session.close();
		}
		if(commentList!=null){
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_TID_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_TID_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("commentList", commentList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result getByHotComment(int start) {
		// TODO get comment by hot comment 
		Result result = new Result();
		List<Comment> commentList = new ArrayList<Comment>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Comment  order by good DESC ";
			commentList = session.createQuery(hQLString).setFirstResult(start).setMaxResults(10).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_NAME_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_NAME_ERROR));
		} finally {
			session.close();
		}
		if(commentList!=null){
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_NAME_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_NAME_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("commentList", commentList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}
	@Override
	public Result getByName(String commentCode) {
		// TODO get comment by comment code
		Result result = new Result();
		List<Comment> commentList = new ArrayList<Comment>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Comment where name like '%"+ commentCode +"%'  order by good";
			commentList = session.createQuery(hQLString).setFirstResult(0).setMaxResults(10).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_NAME_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_NAME_ERROR));
		} finally {
			session.close();
		}
		if(commentList!=null){
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_NAME_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_NAME_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("commentList", commentList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result getByTime(String writeTime) {
		// TODO get comment by write time 
		Result result = new Result();
		List<Comment> commentList = new ArrayList<Comment>();
		session = sessionFactory.openSession();
		Transaction	transaction = session.beginTransaction();
		try {
			String hQLString = " from Comment where write_time = '"+ writeTime + "'";
			commentList = session.createQuery(hQLString).list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_WRITE_TIME_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_WRITE_TIME_ERROR));
		} finally {
			session.close();
		}
		if(commentList!=null){
			result.setErrorCode(ErrorCode.GET_COMMENT_BY_WRITE_TIME_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_BY_WRITE_TIME_OK));
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("commentList", commentList);
			result.setParams(params);
			logger.debug(result.getMessage());
		}

		return result;
	}

	@Override
	public Result updateComment(Comment comment) {
		// TODO update comment 
		Result result = new Result();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(comment);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ErrorCode.UPDATE_COMMENT_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.UPDATE_COMMENT_ERROR));
		} finally {
			session.close();
		}
		if(result.getErrorCode()==null){
			result.setErrorCode(ErrorCode.UPDATE_COMMENT_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.UPDATE_COMMENT_OK));
			logger.debug(result.getMessage());
		}
		return result;
	}

}
