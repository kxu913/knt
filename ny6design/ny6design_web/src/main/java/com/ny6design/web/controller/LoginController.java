package com.ny6design.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kevin.notification.core.MimeMailService;
import com.kevin.notification.model.EmailNotify;
import com.ny6design.mapper.UserMapper;
import com.ny6design.model.User;
import com.ny6design.web.constant.CONSTANT;

/**
 * 
 * @author kevin
 * 
 */
@Controller
public class LoginController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserMapper userMapper;

	@RequestMapping(value = "/doLogin", method = { RequestMethod.GET })
	public String doLogin() {
		return "login";
	}

	@RequestMapping(value = "login", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String url = request.getParameter("url");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("emailAddress", email);
		params.put("password", password);
		User user = userMapper.selectUser(params);
		if (user != null) {
			rtn.put(CONSTANT.EMAIL, email);
			rtn.put(CONSTANT.URL, url);
			request.getSession().setAttribute("userName", user.getFirstname()+ " "+user.getLastname());
		} else {
			rtn.put(CONSTANT.ERROR_MESSAGE, "Eamil or password error!");
		}
		return rtn;
	}

	@RequestMapping(value = "loginOut", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String loginOut(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().removeAttribute("userName");
		return "redirect:index.html";
	}

	@RequestMapping(value = "/doRegist", method = { RequestMethod.GET })
	public String doRegist() {
		// try {
		// mimeMailService.sendPredefinedTemplateMail(this
		// .createNotification());
		// } catch (MessagingException e) {
		// log.error("Send email failed!");
		// }
		return "register";
	}

}
