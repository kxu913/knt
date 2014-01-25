package com.ny6design.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ny6design.service.UserService;

/**
 * 
 * @author kevin
 * 
 */
@Controller
public class UserController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;

	@RequestMapping("getAllUsers")
	public ModelAndView getAllUsers(ModelMap model) {
		if (log.isTraceEnabled()) {
			log.trace("Invoke Get All user method!");
		}
		model.put("userList", userService.getAllUsers());
		return new ModelAndView("member-list", model);

	}
}
