package org.tdgo.CourseIntroduction.dao;

import org.tdgo.CourseIntroduction.vo.Lesson;
import org.tdgo.CourseIntroduction.vo.Result;

public interface LessonDao {
	/*
	 * @Description:����Lesson
	 * @Author:Derik
	 */
	public Result addLesson(Lesson lesson);
	/*
	 * @Description:����Lesson
	 * @Author:Derik
	 */
	public Result updateLesson(Lesson lesson);
	/*
	 * @Description:ɾ��Lesson
	 * @Author:Derik
	 */
	public Result deleteLesson(Lesson lesson);
	/*
	 * @Description:���ݿγ�ID��ѯLesson
	 * @Author:Derik
	 */
	public Result getByLID(Integer lessonID);
	/*
	 * @Description:������ʦID��ѯLesson
	 * @Author:Derik
	 */
	public Result getByTID(Integer teacherID);
	/*
	 * @Description:����ѧԺID��ѯLesson
	 * @Author:Derik
	 */
	public Result getByAID(Integer academyID);
	/*
	 * @Description:���ݿγ����ʻ�ȡLesson
	 * @Author:Derik
	 */
	public Result getByProperty(String property, int start);
	/*
	 * @Description:���ݿγ����ֻ�ȡLesson
	 * @Author:Derik
	 */
	public Result getByName(String name);
	public Result getSearchByVague(String name,int start);
	public Result getSearchByScore(int start,String order);
	public Result getSearchByComment(int start,String order);
	/*
	 * @Description:���ݿγ̷�����ȡLesson
	 * @Author:Derik
	 */
//	public Result getByScore(Integer score);
	public Result getByStatus(String status,Integer start);
}
