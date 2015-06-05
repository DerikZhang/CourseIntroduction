package org.tdgo.CourseIntroduction.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class viewController {

	
	//��ҳ
	@RequestMapping("index")
	public ModelAndView index(){
		
		return new ModelAndView("home");
	}//��ҳ
	
	//��̨
	@RequestMapping("login")
	public ModelAndView login(){
		
		return new ModelAndView("login");
	}

	@RequestMapping("kcgl")
	public ModelAndView kcgl(){
		
		return new ModelAndView("kcgl");
	}

	@RequestMapping("plgl")
	public ModelAndView plgl(){
		
		return new ModelAndView("plgl");
	}	
	
	@RequestMapping("jsgl")
	public ModelAndView jsgl(){
		
		return new ModelAndView("jsgl");
	}
	
}
