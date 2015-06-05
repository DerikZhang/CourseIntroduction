package org.tdgo.CourseIntroduction.dao;

import org.tdgo.CourseIntroduction.vo.Result;
import org.tdgo.CourseIntroduction.vo.Teacher;

public interface TeacherDao {
	/*
	 * @Description:����Teacher
	 * @Author:Derik
	 */
	public Result addTeacher(Teacher teacher);
	/*
	 * @Description:����Teacher
	 * @Author:Derik
	 */
	public Result updateTeacher(Teacher teacher);
	/*
	 * @Description:ɾ��Teacher
	 * @Author:Derik
	 */
	public Result deleteTeacher(Teacher teacher);
	/*
	 * @Description:������ʦID��ȡTeacher
	 * @Author:Derik
	 */
	public Result getByTID(Integer teacherID);
	/*
	 * @Description:����ѧԺID��ȡTeacher
	 * @Author:Derik
	 */
	public Result getByAID(Integer academyID);
	/*
	 * @Description:������ʦ���ֻ�ȡTeacher
	 * @Author:Derik
	 */
	public Result getByName(String name);
	public Result getByName(String name, int start);
	/*
	 * @Description:������ʦ������ȡTeacher
	 * @Author:Derik
	 */
//	public Result getByScore(Integer score);
}
