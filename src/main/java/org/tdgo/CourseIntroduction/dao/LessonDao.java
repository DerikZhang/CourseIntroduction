package org.tdgo.CourseIntroduction.dao;

import org.tdgo.CourseIntroduction.vo.Lesson;
import org.tdgo.CourseIntroduction.vo.Result;

public interface LessonDao {
	/*
	 * @Description:增加Lesson
	 * @Author:Derik
	 */
	public Result addLesson(Lesson lesson);
	/*
	 * @Description:更新Lesson
	 * @Author:Derik
	 */
	public Result updateLesson(Lesson lesson);
	/*
	 * @Description:删除Lesson
	 * @Author:Derik
	 */
	public Result deleteLesson(Lesson lesson);
	/*
	 * @Description:根据课程ID查询Lesson
	 * @Author:Derik
	 */
	public Result getByLID(Integer lessonID);
	/*
	 * @Description:根据老师ID查询Lesson
	 * @Author:Derik
	 */
	public Result getByTID(Integer teacherID);
	/*
	 * @Description:根据学院ID查询Lesson
	 * @Author:Derik
	 */
	public Result getByAID(Integer academyID);
	/*
	 * @Description:根据课程性质获取Lesson
	 * @Author:Derik
	 */
	public Result getByProperty(String property, int start);
	/*
	 * @Description:根据课程名字获取Lesson
	 * @Author:Derik
	 */
	public Result getByName(String name);
	public Result getSearchByVague(String name,int start);
	public Result getSearchByScore(int start,String order);
	public Result getSearchByComment(int start,String order);
	/*
	 * @Description:根据课程分数获取Lesson
	 * @Author:Derik
	 */
//	public Result getByScore(Integer score);
	public Result getByStatus(String status,Integer start);
}
