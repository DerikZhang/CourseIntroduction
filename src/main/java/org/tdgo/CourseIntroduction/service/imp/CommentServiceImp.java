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
import org.tdgo.CourseIntroduction.bo.CommentBo;
import org.tdgo.CourseIntroduction.bo.GoodComment;
import org.tdgo.CourseIntroduction.common.ErrorCode;
import org.tdgo.CourseIntroduction.dao.CommentDao;
import org.tdgo.CourseIntroduction.dao.LessonDao;
import org.tdgo.CourseIntroduction.dao.TeacherDao;
import org.tdgo.CourseIntroduction.service.CommentService;
import org.tdgo.CourseIntroduction.util.CommonFunction;
import org.tdgo.CourseIntroduction.vo.Comment;
import org.tdgo.CourseIntroduction.vo.Lesson;
import org.tdgo.CourseIntroduction.vo.Result;
import org.tdgo.CourseIntroduction.vo.Teacher;

@Repository("commentService")
public class CommentServiceImp implements CommentService {

	@Resource
	CommentDao commentDao;
	
	@Resource
	LessonDao lessonDao;
	
	@Resource
	TeacherDao teacherDao;
	
	private Logger logger = LoggerFactory.getLogger(OperatServiceImp.class);
	
	@Override
	public Result commentLesson(Comment comment) {
		// TODO comment the lesson 
		Result result = new Result();
		Lesson lesson = new Lesson();
		Teacher teacher = new Teacher();
		//Verifiy Comment 
		if(comment.getTeacherID()==null){
			result.setErrorCode(ErrorCode.TEACHER_ID_NULL);
			result.setErrorCode(ErrorCode.MESSAGE_MAP.get(ErrorCode.TEACHER_ID_NULL));
			logger.debug(result.getMessage());
		}else if(comment.getLessonID()==null){
			result.setErrorCode(ErrorCode.LESSON_ID_NULL);
			result.setErrorCode(ErrorCode.MESSAGE_MAP.get(ErrorCode.LESSON_ID_NULL));
			logger.debug(result.getMessage());
		}else if(comment.getScore()==null){
			result.setErrorCode(ErrorCode.SCORE_ID_NULL);
			result.setErrorCode(ErrorCode.MESSAGE_MAP.get(ErrorCode.SCORE_ID_NULL));
			logger.debug(result.getMessage());
		}else {//get roll code & write time
			comment.setCommentCode(CommonFunction.getCommentCode());
			comment.setWriteTime(CommonFunction.getTime());
			//add comment into DB
			result = commentDao.addComment(comment);
			if(result.getErrorCode()!=ErrorCode.ADD_COMMENT_OK){
				result.setErrorCode(ErrorCode.ADD_COMMENT_ERROR);
				result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.ADD_COMMENT_ERROR));
				logger.debug(result.getMessage() + "in commentLesson");
			}else{
				//add lesson score into DB
				Result lsnResult = lessonDao.getByLID(comment.getLessonID());
				if(lsnResult.getErrorCode()!=ErrorCode.GET_LESSON_BY_LID_OK){
					result.setErrorCode(ErrorCode.GET_LESSON_BY_LID_ERROR);
					result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_LESSON_BY_LID_ERROR));
					logger.debug(result.getMessage() + "in commentLesson");
				}else{
					lesson = (Lesson) lsnResult.getParams().get("lesson");
					//设置平均分数到Lesson中
					Double lsnScore = (lesson.getScore()*lesson.getCommentTime()+comment.getScore())/(lesson.getCommentTime()+1);
					lesson.setCommentTime(lesson.getCommentTime()+1);
					lesson.setScore(lsnScore);
					lsnResult = lessonDao.updateLesson(lesson);
					if(lsnResult.getErrorCode()!=ErrorCode.UPDATE_LESSON_OK){
						result.setErrorCode(ErrorCode.UPDATE_LESSON_ERROR);
						result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.UPDATE_LESSON_ERROR));
						logger.debug(result.getMessage() + "in commentLesson");
					}else{
						//add teacher score into DB
						Result tchResult = teacherDao.getByTID(comment.getTeacherID());
						if(tchResult.getErrorCode()!=ErrorCode.GET_TEACHER_BY_TID_OK){
							result.setErrorCode(ErrorCode.GET_TEACHER_BY_TID_ERROR);
							result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_TEACHER_BY_TID_ERROR));
							logger.debug(result.getMessage() + "in commentLesson");
						}else{
							//设置教师平均分
							teacher = (Teacher) tchResult.getParams().get("teacher");
							Double tchScore = (teacher.getScore()*teacher.getCommentTimes()+comment.getScore())/(teacher.getCommentTimes()+1);
							teacher.setCommentTimes(teacher.getCommentTimes()+1);
							teacher.setScore(tchScore);
							tchResult = teacherDao.updateTeacher(teacher);
							if(tchResult.getErrorCode()!=ErrorCode.UPDATE_TEACHER_OK){
								result.setErrorCode(ErrorCode.UPDATE_TEACHER_ERROR);
								result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.UPDATE_TEACHER_ERROR));
								logger.debug(result.getMessage() + "in commentLesson");
							}else{
								//return result
								result.setErrorCode(ErrorCode.COMMENT_LESSON_OK);
								result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.COMMENT_LESSON_OK));
								logger.debug(result.getMessage());
							}
						}
					}

				}
			}
			
		}
		if(result.getErrorCode()!=ErrorCode.COMMENT_LESSON_OK){
			result.setErrorCode(ErrorCode.COMMENT_LESSON_ERROR);
			logger.debug(result.getMessage()+"in comment lesson");
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.COMMENT_LESSON_ERROR));
		}
		return result;
	}

	@Override
	public Result goodComment(GoodComment goodComment) {
		// TODO get a good-star to comment 
		Result result = new Result();
		Comment comment = new Comment();
		result = commentDao.getByCID(goodComment.getCommentId());
		if(result.getErrorCode()==ErrorCode.GET_COMMENT_BY_CID_OK){
			logger.debug(result.getMessage());
			comment = (Comment) result.getParams().get("comment");
			if(goodComment.getGood()){
				comment.setGood(comment.getGood()+1);
			}else{
				comment.setGood(comment.getGood()-1);
			}
			result = commentDao.updateComment(comment);
			if(result.getErrorCode()==ErrorCode.UPDATE_COMMENT_OK){
				result.setErrorCode(ErrorCode.GOOD_COMMENT_OK);
				result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GOOD_COMMENT_OK));
				logger.debug(result.getMessage()+"in comment service");
			}
		}
		if(result.getErrorCode()!=ErrorCode.GOOD_COMMENT_OK){
			result.setErrorCode(ErrorCode.GOOD_COMMENT_ERROR);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GOOD_COMMENT_ERROR));
			logger.debug(result.getMessage()+"in comment service");
		}
		return result;
	}

	@Override
	public Result getCommentInfo(Integer lesson_id,Integer page){
		int start = (page - 1)*10;
		List<Comment> commentList = new ArrayList<Comment>();
		List<CommentBo> commentBoList = new ArrayList<CommentBo>();
		Map<String, Object> map = new HashMap<String, Object>();
		Result result = commentDao.getByLID(lesson_id,start);
		if(result.getErrorCode()==ErrorCode.GET_COMMENT_BY_LID_OK){
			commentList = (List<Comment>) result.getParams().get("commentList");
			for (Comment comment : commentList) {
				CommentBo commentBo = new CommentBo();
				commentBo.setComment(comment.getComment());
				commentBo.setCommentId(comment.getCommentID());
				commentBo.setCommentCode(comment.getCommentCode());
				commentBo.setGood(comment.getGood());
				commentBo.setWriteTime(comment.getWriteTime());
				commentBoList.add(commentBo);
			}
			map.put("commentBoList", commentBoList);
			result.setErrorCode(ErrorCode.GET_COMMENT_INFO_OK);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.GET_COMMENT_INFO_OK));
			result.setParams(map);
			logger.debug(result.getMessage()+"in comment service");
		}
		return result;
	}

}
