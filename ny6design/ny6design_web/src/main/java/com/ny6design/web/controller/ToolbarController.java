package com.ny6design.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author kevin
 * 
 */
@Controller
public class ToolbarController {
	@RequestMapping("/getToolBar")
	public ModelAndView getToolbar(HttpServletRequest request, ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("logintoolbar", model);
		Object userName = request.getSession().getAttribute("userName");
		if (userName != null) {
			model.put("userName", userName.toString());
		}
		return modelAndView;
	}
}
