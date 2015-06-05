package org.tdgo.CourseIntroduction.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tdgo.CourseIntroduction.bo.GoodComment;
import org.tdgo.CourseIntroduction.bo.LessonBo;
import org.tdgo.CourseIntroduction.common.APICode;
import org.tdgo.CourseIntroduction.common.ErrorCode;
import org.tdgo.CourseIntroduction.service.CommentService;
import org.tdgo.CourseIntroduction.service.LessonService;
import org.tdgo.CourseIntroduction.service.imp.LessonServiceImp;
import org.tdgo.CourseIntroduction.vo.Comment;
import org.tdgo.CourseIntroduction.vo.Lesson;
import org.tdgo.CourseIntroduction.vo.Result;

@Controller
public class CommentController {

	@Resource
	CommentService commentService;
	
	@Resource
	LessonService lessonService;


	/*
	 * @Author:DerikZ
	 * @Description:get the commentBoList of lesson_id and lessonBo and loading kecheng/{lesson_id} page
	 * @Time:2015-06-04 02:49pm
	 */
	@RequestMapping("kecheng/{lesson_id}")
	public ModelAndView kecheng(@PathVariable Integer lesson_id,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		LessonBo lessonBo = new LessonBo();
		Lesson lesson = new Lesson();
		lesson.setLessonID(lesson_id);
		Result result = lessonService.getLessonBoByID(lesson);
		if(result.getErrorCode()==ErrorCode.GET_LESSONBO_BY_ID_OK){
			lessonBo = (LessonBo) result.getParams().get("lessonBo");
			map.put("lessonBo",lessonBo);
//			request.getSession().setAttribute("lessonName", lessonBo.getLessonName());
//			request.getSession().setAttribute("lessonId", lessonBo.getLessonId());
//			request.getSession().setAttribute("teacherName", lessonBo.getTeacherName());	
//			request.getSession().setAttribute("teacherId", lessonBo.getTeacherId());
//			for (LessonBo lessonBo : lessonBoList) {
//				teacherNameList.add(lessonBo.getTeacherName());
//				teacherIdList.add(lessonBo.getTeacherId());
//			}
//			request.getSession().setAttribute("teacherNameList", teacherNameList);	
//			request.getSession().setAttribute("teacherIdList", teacherIdList);
		}
		result = commentService.getCommentInfo(lesson_id, 1);
		if(result.getErrorCode()==ErrorCode.GET_COMMENT_INFO_OK){
			map.put("commentBoList",result.getParams().get("commentBoList"));
		}
		return new ModelAndView("kecheng",map);
	}

	/*
	 * @Author:DerikZ
	 * @Description:this is API of giving a good-star to {comment_id}
	 * @Time:2015-06-04 02:49pm
	 */
	@RequestMapping("kecheng/goodComment/{comment_id}/{good}")
	@ResponseBody
	public Map<String, Object> goodComment(@PathVariable Integer comment_id,@PathVariable Boolean good
			,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("comment_id",comment_id);
		GoodComment goodComment = new GoodComment();
		goodComment.setCommentId(comment_id);
		goodComment.setGood(good);
		Result result = commentService.goodComment(goodComment);
		if(result.getErrorCode()==ErrorCode.GOOD_COMMENT_OK){
			map.put("status", "success");
		}else{
			map.put("status", "failure");
		}
		return map;
	}
	/*
	 * @Author:DerikZ
	 * @Description:this is API of getting commentBoList by {lesson_id} with page number
	 * @Time:2015-06-04 02:49pm
	 */
	@RequestMapping("kecheng/getComment/{lesson_id}/{page}")
	@ResponseBody
	public Result getComment(@PathVariable Integer lesson_id,@PathVariable Integer page
			,HttpServletRequest request,HttpServletResponse response){
		Result result = new Result();
		if(lesson_id==null||lesson_id<0){
			result.setErrorCode(ErrorCode.LESSON_ID_NULL);
			result.setMessage(ErrorCode.MESSAGE_MAP.get(ErrorCode.LESSON_ID_NULL));
		}else{
			result = commentService.getCommentInfo(lesson_id,page);
			if(result.getErrorCode()==ErrorCode.GET_COMMENT_INFO_OK){
				result.setErrorCode(APICode.GET_COMMENT_OK);
				result.setMessage(ErrorCode.MESSAGE_MAP.get(APICode.GET_COMMENT_OK));
			}
		}
		return result;
	}
	/*
	 * @Author:DerikZ
	 * @Description:judge the lesson of {lesson_id}
	 * @Time:2015-06-04 02:49pm
	 */
	@RequestMapping("kecheng/judge/{lesson_id}/{teacher_id}")
	public ModelAndView judge(@PathVariable Integer lesson_id,@PathVariable Integer teacher_id 
			,@ModelAttribute("commentString") String commentString,@ModelAttribute("score") Double score
			,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Comment comment = new Comment();
		comment.setLessonID(lesson_id);
		comment.setGood(0);
		comment.setTeacherID(teacher_id);
		comment.setScore(score);
//		String commentString = (String) request.getAttribute("comment");
		comment.setComment(commentString);
		Result result = commentService.commentLesson(comment);
		if(result.getErrorCode()==ErrorCode.COMMENT_LESSON_OK){
			return new ModelAndView("redirect:/kecheng/"+lesson_id,result.getParams());
		}else{
			map.put("message","∆¿¬€ ß∞‹");
			return new ModelAndView("redirect:/kecheng/"+lesson_id,map);
		}
	}
	
	
	
}
