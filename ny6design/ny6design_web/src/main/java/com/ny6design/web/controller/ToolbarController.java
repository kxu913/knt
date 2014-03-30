package com.ny6design.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ny6design.model.WishListKey;
import com.ny6design.service.WishListService;

/**
 * 
 * @author kevin
 * 
 */
@Controller
public class ToolbarController {
	
	@Autowired
	private WishListService wishListService;
	
	@RequestMapping("/getToolBar")
	public ModelAndView getToolbar(HttpServletRequest request, ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("logintoolbar", model);
		Object userName = request.getSession().getAttribute("userName");
		Object userid = request.getSession().getAttribute("userid");
		if (userName != null) {
			model.put("userName", userName.toString());
		}
		
		//set wish list number
		if(userid!=null){
			List<WishListKey> list = wishListService.getWishListByUserId((Integer)userid);
			if(list!=null && list.size()>0){
				model.put("wishListNum", list.size());
			}
		}
		return modelAndView;
	}
}
