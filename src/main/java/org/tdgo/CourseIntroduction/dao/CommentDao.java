package org.tdgo.CourseIntroduction.dao;

import org.tdgo.CourseIntroduction.vo.Comment;
import org.tdgo.CourseIntroduction.vo.Result;

public interface CommentDao {
	/*
	 * @Description:增加Comment
	 * @Author:Derik
	 */
	public Result addComment(Comment comment);
	/*
	 * @Description:更新Comment
	 * @Author:Derik
	 */
	public Result updateComment(Comment comment);
	/*
	 * @Description:删除Comment
	 * @Author:Derik
	 */
	public Result deleteComment(Comment comment);
	/*
	 * @Description:根据评论ID查询Comment
	 * @Author:Derik
	 */
	public Result getByCID(Integer commentID);
	/*
	 * @Description:根据课程ID查询Comment
	 * @Author:Derik
	 */
	public Result getByLID(Integer lessonID, Integer page);
	/*
	 * @Description:根据老师ID查询Comment
	 * @Author:Derik
	 */
	public Result getByTID(Integer teacherID);
	/*
	 * @Description:根据CommentCode查询Comment
	 * @Author:Derik
	 */
	public Result getByName(String commentCode);
	public Result getByHotComment(int start);
	/*
	 * @Description:根据写下时间查询Comment
	 * @Author:Derik
	 */
	public Result getByTime(String writeTime);
	/*
	 * @Description:根据点赞书查询Comment
	 * @Author:Derik
	 */
//	public Result getByGood(Integer good);
	
}
