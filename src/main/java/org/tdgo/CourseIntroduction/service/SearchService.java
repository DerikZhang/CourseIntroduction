package org.tdgo.CourseIntroduction.service;

import java.util.Map;

import org.tdgo.CourseIntroduction.bo.LessonBo;
import org.tdgo.CourseIntroduction.bo.RequestSearch;
import org.tdgo.CourseIntroduction.vo.Result;

public interface SearchService {
	/*
	 * @Description:�߷ְ�
	 */
	public Result getScoreLesson(RequestSearch requestSearch);
	/*
	 * @Description:������
	 */
	public Result getCommentLesson(RequestSearch requestSearch);
	/*
	 * @Description:ģ������
	 */
	public Result vagueSearchLesson(RequestSearch requestSearch);
}
