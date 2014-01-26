package com.ny6design.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kevin.security.token.EmailPasswordToken;
import com.ny6design.mapper.UserMapper;
import com.ny6design.model.User;
import com.ny6design.service.UserService;
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
	UserService userService;

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
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		if (StringUtils.isNotEmpty(email)) {
			EmailPasswordToken token = new EmailPasswordToken(email, password,
					true, request.getRemoteHost(), email);
			try {
				if (log.isInfoEnabled()) {
					log.info("对用户[" + email + "]进行登录验证..验证开始");
				}
				currentUser.login(token);
				User user = userService.findUserByEmail(email);
				if (user != null) {
					rtn.put(CONSTANT.EMAIL, email);
					rtn.put(CONSTANT.URL, url);
					request.getSession().setAttribute("userName",
							user.getFirstname() + " " + user.getLastname());
					request.getSession().setAttribute("userid",
							user.getUserid());
				}
				if (log.isInfoEnabled()) {
					log.info("对用户[" + email + "]进行登录验证..验证通过");
				}

			} catch (UnknownAccountException uae) {
				log.error("对用户[" + email + "]进行登录验证..验证未通过,未知账户");
				rtn.put(CONSTANT.ERROR_MESSAGE, "Eamil or password error!");
			} catch (IncorrectCredentialsException ice) {
				log.error("对用户[" + email + "]进行登录验证..验证未通过,错误的凭证");
				rtn.put(CONSTANT.ERROR_MESSAGE, "Eamil or password error!");
			} catch (LockedAccountException lae) {
				log.error("对用户[" + email + "]进行登录验证..验证未通过,账户已锁定");
				rtn.put(CONSTANT.ERROR_MESSAGE, "Eamil or password error!");
			} catch (ExcessiveAttemptsException eae) {
				log.error("对用户[" + email + "]进行登录验证..验证未通过,错误次数过多");
				rtn.put(CONSTANT.ERROR_MESSAGE, "Eamil or password error!");
			} catch (AuthenticationException ae) {
				// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
				log.error("对用户[" + email + "]进行登录验证..验证未通过,堆栈轨迹如下");
				ae.printStackTrace();
				rtn.put(CONSTANT.ERROR_MESSAGE, "Eamil or password error!");
			}
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
