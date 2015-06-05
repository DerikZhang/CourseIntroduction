package org.tdgo.CourseIntroduction.service;


import org.tdgo.CourseIntroduction.bo.GoodComment;
import org.tdgo.CourseIntroduction.vo.Comment;
import org.tdgo.CourseIntroduction.vo.Result;

public interface CommentService {

	public Result commentLesson(Comment comment);
//	public Result commentTeacher(Comment comment);
	
	public Result goodComment(GoodComment goodComment);
	
	public Result getCommentInfo(Integer lesson_id, Integer page);
}
