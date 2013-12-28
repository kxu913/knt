package com.knt.frontpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginCotroller {
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "success");
		return modelAndView;
	}
}
