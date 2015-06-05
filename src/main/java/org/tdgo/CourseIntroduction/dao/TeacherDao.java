package org.tdgo.CourseIntroduction.dao;

import org.tdgo.CourseIntroduction.vo.Result;
import org.tdgo.CourseIntroduction.vo.Teacher;

public interface TeacherDao {
	/*
	 * @Description:增加Teacher
	 * @Author:Derik
	 */
	public Result addTeacher(Teacher teacher);
	/*
	 * @Description:更新Teacher
	 * @Author:Derik
	 */
	public Result updateTeacher(Teacher teacher);
	/*
	 * @Description:删除Teacher
	 * @Author:Derik
	 */
	public Result deleteTeacher(Teacher teacher);
	/*
	 * @Description:根据老师ID获取Teacher
	 * @Author:Derik
	 */
	public Result getByTID(Integer teacherID);
	/*
	 * @Description:根据学院ID获取Teacher
	 * @Author:Derik
	 */
	public Result getByAID(Integer academyID);
	/*
	 * @Description:根据老师名字获取Teacher
	 * @Author:Derik
	 */
	public Result getByName(String name);
	public Result getByName(String name, int start);
	/*
	 * @Description:根据老师分数获取Teacher
	 * @Author:Derik
	 */
//	public Result getByScore(Integer score);
}
