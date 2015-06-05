package org.tdgo.CourseIntroduction.dao;

import org.tdgo.CourseIntroduction.vo.Academy;
import org.tdgo.CourseIntroduction.vo.Result;

public interface AcademyDao {
	/*
	 * @Description:增加Academy
	 * @Author:Derik
	 */
	public Result addAcademy(Academy academy);
	/*
	 * @Description:更新Academy
	 * @Author:Derik
	 */
	public Result updateAcademy(Academy academy);
	/*
	 * @Description:删除Academy
	 * @Author:Derik
	 */
	public Result deleteAcademy(Academy academy);
	/*
	 * @Description:根据学院ID获取Academy
	 * @Author:Derik
	 */
	public Result getByAID(Integer academyID);
	/*
	 * @Description:根据学院名字获取Academy
	 * @Author:Derik
	 */
	public Result getByName(String name);
	public Result getByName(String name, int start);
}
