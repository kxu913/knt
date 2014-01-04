package com.knt.frontpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knt.core.MappForMybatis;
import com.knt.frontpage.core.JsonUtil;
import com.knt.mapping.UserForTestMapper;
import com.knt.model.UserForTest;

@Controller
public class UserController {
	@Autowired
	private MappForMybatis businessManager;
	
	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	@ResponseBody
	public String getUserList(HttpServletResponse response) {
		UserForTestMapper mapper = businessManager.getMapper(UserForTestMapper.class); 
		List<UserForTest> list = mapper.getUserList();
		return JsonUtil.beanListToJson(response, list);
	}
}
