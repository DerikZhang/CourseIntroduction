package org.tdgo.CourseIntroduction.dao;

import org.tdgo.CourseIntroduction.vo.Academy;
import org.tdgo.CourseIntroduction.vo.Result;

public interface AcademyDao {
	/*
	 * @Description:����Academy
	 * @Author:Derik
	 */
	public Result addAcademy(Academy academy);
	/*
	 * @Description:����Academy
	 * @Author:Derik
	 */
	public Result updateAcademy(Academy academy);
	/*
	 * @Description:ɾ��Academy
	 * @Author:Derik
	 */
	public Result deleteAcademy(Academy academy);
	/*
	 * @Description:����ѧԺID��ȡAcademy
	 * @Author:Derik
	 */
	public Result getByAID(Integer academyID);
	/*
	 * @Description:����ѧԺ���ֻ�ȡAcademy
	 * @Author:Derik
	 */
	public Result getByName(String name);
	public Result getByName(String name, int start);
}
