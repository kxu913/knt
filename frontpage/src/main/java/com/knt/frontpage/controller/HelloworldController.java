package com.knt.frontpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloworldController {

	@RequestMapping("/index")
	public ModelAndView simple() {

		ModelAndView modelAndView = new ModelAndView("user/userDetail");
		modelAndView.addObject("message", "success");
		return modelAndView;

	}
}
