package com.knt.frontpage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.knt.frontpage.security.CaptchaFormAuthenticationFilter;
import com.knt.frontpage.security.CaptchaUsernamePasswordToken;

@Controller
public class LoginCotroller {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/login.do", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("loginName");
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		ModelAndView modelAndView = new ModelAndView();
		if (username != null) {
			String password = request.getParameter("password");
			String captcha = request.getParameter("captcha");
			System.out.println(username + " : " + password);
			CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
					username, password, true, request.getRemoteHost(), captcha);

			try {
				if (log.isTraceEnabled()) {
					log.trace("对用户[" + username + "]进行登录验证..验证开始");
				}
				currentUser.login(token);
				if (log.isTraceEnabled()) {
					log.trace("对用户[" + username + "]进行登录验证..验证通过");
				}

			} catch (UnknownAccountException uae) {
				log.error("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
				request.setAttribute("message_login", "未知账户");
			} catch (IncorrectCredentialsException ice) {
				log.error("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
				request.setAttribute("message_login", "密码不正确");
			} catch (LockedAccountException lae) {
				log.error("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
				request.setAttribute("message_login", "账户已锁定");
			} catch (ExcessiveAttemptsException eae) {
				log.error("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
				request.setAttribute("message_login", "用户名或密码错误次数过多");
			} catch (AuthenticationException ae) {
				// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
				log.error("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
				ae.printStackTrace();
				request.setAttribute("message_login", "用户名或密码不正确");
			}
			// 验证是否登录成功
			if (currentUser.isAuthenticated()) {
				modelAndView.addObject("userName", username);
				modelAndView.addObject("password", password);
				modelAndView.setViewName("redirect:admin/adminDetail");
				return modelAndView;
			}
		}
		modelAndView.addObject(
				"verifiCode",
				currentUser.getSession(false).getAttribute(
						CaptchaFormAuthenticationFilter.DEFAULT_CAPTCHA_PARAM));
		modelAndView.setViewName("redirect:login.html");
		return modelAndView;
	}

	@RequestMapping(value = "/loginoff", method = RequestMethod.GET)
	public ModelAndView logoff() {
		ModelAndView modelAndView = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		modelAndView.setViewName("redirect:login.html");
		return modelAndView;
	}
}
