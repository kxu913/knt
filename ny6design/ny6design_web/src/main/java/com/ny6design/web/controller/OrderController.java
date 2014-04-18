package com.ny6design.web.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ny6design.model.OrderSummaryDetail;
import com.ny6design.service.OrderSummayService;

/**
 * 
 * @author kxu
 * 
 */
@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	OrderSummayService orderSummaryService;

	@RequestMapping("listForUser")
	public ModelAndView listOrdersForUser(HttpServletRequest request, HttpServletResponse response, final ModelMap model) {
		int userId = getUserId(request);
		List<OrderSummaryDetail> rtn = Collections.emptyList();
		if (userId > 0) {
			rtn = orderSummaryService.findOrdersByUserId(userId);
		}
		model.put("orders", rtn);
		return new ModelAndView("user/orderlist", model);
	}

	private int getUserId(HttpServletRequest request) {
		Object _userId = request.getSession().getAttribute("userid");
		int userId = 0;
		if (_userId != null) {
			userId = (Integer) _userId;
		}
		return userId;
	}
}
