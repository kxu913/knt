package com.ny6design.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	
	@RequestMapping("searchUsers")
	public ModelAndView searchUsers(ModelMap model, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		if (log.isTraceEnabled()) {
			log.trace("Invoke Search user method! keywords is " + keyword);
		}
		model.put("userList", userService.searchUsers(keyword));
		return new ModelAndView("member-list", model);

	}
	
	@RequestMapping("getUserById")
	public ModelAndView getUserById(ModelMap model, HttpServletRequest request) {
		String userId = request.getParameter("userId");
		if (log.isTraceEnabled()) {
			log.trace("Invoke Get User by Id!" + userId);
		}
		model.put("user", userService.getUserById(userId));
		return new ModelAndView("member-edit", model);
	}

	@RequestMapping("getUserByIdForAcct")
	public ModelAndView getUserByIdForAcct(ModelMap model,
			HttpServletRequest request) {
		if (request.getSession().getAttribute("userid") != null) {
			String userId = request.getSession().getAttribute("userid")
					.toString();
			if (log.isTraceEnabled()) {
				log.trace("Invoke Get User by Id!" + userId);
			}
			model.put("user", userService.getUserById(userId));
		}
		return new ModelAndView("account-edit", model);
	}
	
	@RequestMapping(value = "/loadUserPanel", method = { RequestMethod.GET })
	public String doLogin() {
		return "userpanel";
	}
	
	
	@RequestMapping("getUserWishList")
	public ModelAndView getUserWishList(ModelMap model, HttpServletRequest request) {
		String userId = request.getParameter("userId");
		if (log.isTraceEnabled()) {
			log.trace("Invoke Get User by Id!" + userId);
		}
		model.put("user", userService.getUserById(userId));
		return new ModelAndView("member-edit", model);
	}
	
}
