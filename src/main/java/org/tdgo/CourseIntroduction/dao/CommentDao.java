package org.tdgo.CourseIntroduction.dao;

import org.tdgo.CourseIntroduction.vo.Comment;
import org.tdgo.CourseIntroduction.vo.Result;

public interface CommentDao {
	/*
	 * @Description:����Comment
	 * @Author:Derik
	 */
	public Result addComment(Comment comment);
	/*
	 * @Description:����Comment
	 * @Author:Derik
	 */
	public Result updateComment(Comment comment);
	/*
	 * @Description:ɾ��Comment
	 * @Author:Derik
	 */
	public Result deleteComment(Comment comment);
	/*
	 * @Description:��������ID��ѯComment
	 * @Author:Derik
	 */
	public Result getByCID(Integer commentID);
	/*
	 * @Description:���ݿγ�ID��ѯComment
	 * @Author:Derik
	 */
	public Result getByLID(Integer lessonID, Integer page);
	/*
	 * @Description:������ʦID��ѯComment
	 * @Author:Derik
	 */
	public Result getByTID(Integer teacherID);
	/*
	 * @Description:����CommentCode��ѯComment
	 * @Author:Derik
	 */
	public Result getByName(String commentCode);
	public Result getByHotComment(int start);
	/*
	 * @Description:����д��ʱ���ѯComment
	 * @Author:Derik
	 */
	public Result getByTime(String writeTime);
	/*
	 * @Description:���ݵ������ѯComment
	 * @Author:Derik
	 */
//	public Result getByGood(Integer good);
	
}
