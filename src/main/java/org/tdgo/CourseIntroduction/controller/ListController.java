package org.tdgo.CourseIntroduction.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tdgo.CourseIntroduction.bo.RequestSearch;
import org.tdgo.CourseIntroduction.common.APICode;
import org.tdgo.CourseIntroduction.common.Config;
import org.tdgo.CourseIntroduction.common.ErrorCode;
import org.tdgo.CourseIntroduction.service.LessonService;
import org.tdgo.CourseIntroduction.service.SearchService;
import org.tdgo.CourseIntroduction.vo.Result;

@Controller
public class ListController {

	@Resource
	SearchService searchService;
	
	@Resource
	LessonService lessonService;
	
	private Logger logger = LoggerFactory.getLogger(ListController.class);
	
	/*
	 * @Author:DerikZ
	 * @Description:get lesson order by score and loading lower page
	 * @Time:2015-06-04 02:49pm
	 */
	@RequestMapping("lower")
	public ModelAndView lower(HttpServletRequest request,HttpServletResponse response){
		RequestSearch requestSearch = new RequestSearch();
		Map<String, Object> map  = new HashMap<String, Object>();
		requestSearch.setModelFlag(Config.LOW_SCORE_LIST);
		requestSearch.setPage(1);
		Result result = searchService.getScoreLesson(requestSearch);
		if(result.getErrorCode()==ErrorCode.GET_SCORE_LESSON_OK){
			logger.debug(result.getMessage()+"in Controller ok");
			map = result.getParams();
		}else{
			logger.debug(result.getMessage()+"in Controller error");
		}
		return new ModelAndView("lower",map);
	}
	/*
	 * @Author:DerikZ
	 * @Description:this is lower API for getting lesson order by score 
	 * @Time:2015-06-04 02:49pm
	 */
	@RequestMapping("lower/{page}")
	@ResponseBody
	public Result lowerAPI(@PathVariable String page,HttpServletRequest request,HttpServletResponse response){
		RequestSearch requestSearch = new RequestSearch();
		requestSearch.setModelFlag(Config.LOW_SCORE_LIST);
		requestSearch.setPage(Integer.parseInt(page));
		Result result = searchService.getScoreLesson(requestSearch);
		if(result.getErrorCode()==ErrorCode.GET_SCORE_LESSON_OK){
			result.setErrorCode(APICode.GET_LOWER_LIST_SCORE_OK);
			result.setMessage(APICode.MESSAGE_MAP.get(APICode.GET_LOWER_LIST_SCORE_OK));
			logger.debug(result.getMessage()+"in Controller ok");
		}else{
			result.setErrorCode(APICode.GET_LOWER_LIST_SCORE_ERROR);
			result.setMessage(APICode.MESSAGE_MAP.get(APICode.GET_LOWER_LIST_SCORE_ERROR));
			logger.debug(result.getMessage()+"in Controller error");
		}
		return result;
	}
	

	/*
	 * @Author:DerikZ
	 * @Description:get lesson order by score and loading higher page
	 * @Time:2015-06-04 02:49pm
	 */
	@RequestMapping("higher")
	public ModelAndView higher(HttpServletRequest request,HttpServletResponse response){
		RequestSearch requestSearch = new RequestSearch();
		Map<String, Object> map  = new HashMap<String, Object>();
		requestSearch.setModelFlag(Config.HIGHER_SCORE_LIST);
		requestSearch.setPage(1);
		Result result = searchService.getScoreLesson(requestSearch);
		if(result.getErrorCode()==ErrorCode.GET_SCORE_LESSON_OK){
			logger.debug(result.getMessage()+"in Controller ok");
			map = result.getParams();
		}else{
			logger.debug(result.getMessage()+"in Controller error");
		}
		return new ModelAndView("higher",map);
	}
	/*
	 * @Author:DerikZ
	 * @Description:this is higher API for getting lesson order by score 
	 * @Time:2015-06-04 02:49pm
	 */
	@RequestMapping("higher/{page}")
	@ResponseBody
	public Result higherAPI(@PathVariable int page,HttpServletRequest request,HttpServletResponse response){
		RequestSearch requestSearch = new RequestSearch();
		requestSearch.setModelFlag(Config.HIGHER_SCORE_LIST);
		requestSearch.setPage(page);
		Result result = searchService.getScoreLesson(requestSearch);
		if(result.getErrorCode()==ErrorCode.GET_SCORE_LESSON_OK){
			result.setErrorCode(APICode.GET_HIGHER_LIST_SCORE_OK);
			result.setMessage(APICode.MESSAGE_MAP.get(APICode.GET_HIGHER_LIST_SCORE_OK));
			logger.debug(result.getMessage()+"in Controller ok");
		}else{
			result.setErrorCode(APICode.GET_HIGHER_LIST_SCORE_ERROR);
			result.setMessage(APICode.MESSAGE_MAP.get(APICode.GET_HIGHER_LIST_SCORE_ERROR));
			logger.debug(result.getMessage()+"in Controller error");
		}
		return result;
	}

	/*
	 * @Author:DerikZ
	 * @Description:get lesson order by comment times and loading hotter page
	 * @Time:2015-06-04 02:49pm
	 */
	@RequestMapping("hotter")
	public ModelAndView hotter(){
		RequestSearch requestSearch = new RequestSearch();
		Map<String, Object> map  = new HashMap<String, Object>();
		requestSearch.setModelFlag(Config.HOT_COMMENT_LIST);
		requestSearch.setPage(1);
		Result result = searchService.getCommentLesson(requestSearch);
		if(result.getErrorCode()==ErrorCode.GET_COMMENT_LESSON_OK){
			logger.debug(result.getMessage()+"in Controller ok");
			map = result.getParams();
		}else{
			logger.debug(result.getMessage()+"in Controller error");
		}
		return new ModelAndView("hotter",map);
	}
	
	/*
	 * @Author:DerikZ
	 * @Description:this is hotter API for getting lesson order by comment times 
	 * @Time:2015-06-04 02:49pm
	 */
	@RequestMapping("hotter/{page}")
	@ResponseBody
	public Result hotterAPI(@PathVariable int page,HttpServletRequest request,HttpServletResponse response){
		RequestSearch requestSearch = new RequestSearch();
		requestSearch.setModelFlag(Config.HOT_COMMENT_LIST);
		requestSearch.setPage(page);
		Result result = searchService.getCommentLesson(requestSearch);
		if(result.getErrorCode()==ErrorCode.GET_COMMENT_LESSON_OK){
			result.setErrorCode(APICode.GET_HOTTER_LIST_SCORE_OK);
			result.setMessage(APICode.MESSAGE_MAP.get(APICode.GET_HOTTER_LIST_SCORE_OK));
			logger.debug(result.getMessage()+"in Controller ok");
		}else{
			result.setErrorCode(APICode.GET_HOTTER_LIST_SCORE_ERROR);
			result.setMessage(APICode.MESSAGE_MAP.get(APICode.GET_HOTTER_LIST_SCORE_ERROR));
			logger.debug(result.getMessage()+"in Controller error");
		}
		return result;
	}
	/*
	 * @Author:DerikZ
	 * @Description:this is vague-search API for getting lesson by teacher name or lesson name 
	 * @Time:2015-06-04 02:49pm
	 */
	@RequestMapping("vagueSearch/{page}")
	@ResponseBody
	public Result vagueSearch(@PathVariable int page,@ModelAttribute("vagueString") String vagueString
			,HttpServletRequest request,HttpServletResponse response){
		RequestSearch requestSearch = new RequestSearch();
		vagueString = vagueString.trim();
		requestSearch.setPage(page);
		requestSearch.setModelFlag(Config.VAGUE_SEARCH_LIST);
		requestSearch.setLessonName(vagueString);
		requestSearch.setTeacherName(vagueString);
		Result result = searchService.vagueSearchLesson(requestSearch);
		if(result.getErrorCode()==ErrorCode.GET_VAGUE_LESSON_OK){
			result.setErrorCode(APICode.GET_VAGUE_LIST_OK);
			result.setMessage(APICode.MESSAGE_MAP.get(APICode.GET_VAGUE_LIST_OK));
			logger.debug(result.getMessage()+"in Controller ok");
		}else{
			result.setErrorCode(APICode.GET_VAGUE_LIST_ERROR);
			result.setMessage(APICode.MESSAGE_MAP.get(APICode.GET_VAGUE_LIST_ERROR));
			logger.debug(result.getMessage()+"in Controller ok");
		}
		return result;
	}
	

	@RequestMapping("home")
	public ModelAndView home(){
		Result result = lessonService.getLessonBoForHome();
		Map<String, Object> map = new HashMap<String, Object>();
		if(result.getErrorCode()==ErrorCode.GET_LESSONBO_FOR£ßHOME_OK){
			map = result.getParams();
		}
		return new ModelAndView("home",map);
	}
	
}
