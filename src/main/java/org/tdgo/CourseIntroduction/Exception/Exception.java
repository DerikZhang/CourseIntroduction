package org.tdgo.CourseIntroduction.Exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Exception {

	@RequestMapping("exception")
	public ModelAndView exception(){
		return new ModelAndView("exception");
		
	}
}
