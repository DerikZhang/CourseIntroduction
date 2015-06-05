package org.tdgo.CourseIntroduction.service;

import java.util.Map;

import org.tdgo.CourseIntroduction.bo.LessonBo;
import org.tdgo.CourseIntroduction.bo.RequestSearch;
import org.tdgo.CourseIntroduction.vo.Result;

public interface SearchService {
	/*
	 * @Description:高分榜
	 */
	public Result getScoreLesson(RequestSearch requestSearch);
	/*
	 * @Description:热评榜
	 */
	public Result getCommentLesson(RequestSearch requestSearch);
	/*
	 * @Description:模糊搜索
	 */
	public Result vagueSearchLesson(RequestSearch requestSearch);
}
