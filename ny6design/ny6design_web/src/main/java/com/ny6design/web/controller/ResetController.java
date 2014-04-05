package com.ny6design.web.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kevin.notification.core.MimeMailService;
import com.ny6design.model.User;
import com.ny6design.service.UserService;
import com.ny6design.web.email.EmailPropertiesFactory;
import com.ny6design.web.email.ResetEmailThread;

/**
 * 
 * @author kxu
 * 
 */
@Controller
public class ResetController {
	private static final String INVALIDEMAIL = "Can't find your account by this emial, please check it.";
	private static final String SUCCESS = "Please check your email to reset password.";
	private static final String SENDEMAILFAILED = "Can't send email to your emailAddress.";
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EmailPropertiesFactory emailPropertiesFactory;
	@Autowired
	MimeMailService mimeMailService;
	@Autowired
	UserService userService;
	private final ExecutorService executor = Executors
			.newSingleThreadExecutor();

	@RequestMapping("/loadReset")
	public ModelAndView loadResetPage(ModelMap modelMap) {
		return new ModelAndView("resetPassword", modelMap);
	}

	@RequestMapping("/doReset")
	@ResponseBody
	public String reset(HttpServletRequest request) {
		String emailAddress = request.getParameter("email");
		User user = userService.findUserByEmail(emailAddress);
		if (user == null) {
			return INVALIDEMAIL;
		}
		Future<Integer> f = executor.submit(new ResetEmailThread(
				emailPropertiesFactory, mimeMailService, user.getUserid(),
				emailAddress));

		try {
			if (f.get() == 1) {
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Send Email failed!" + e);
		}
		return SENDEMAILFAILED;

	}

}
