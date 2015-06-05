package org.tdgo.CourseIntroduction.Exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Error {

	@RequestMapping("error404")
	public ModelAndView error404(){
		return new ModelAndView("home");
		
	}
}
