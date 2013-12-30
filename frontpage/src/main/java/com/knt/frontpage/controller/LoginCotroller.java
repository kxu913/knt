package com.knt.frontpage.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.knt.frontpage.security.CaptchaUsernamePasswordToken;

@Controller
public class LoginCotroller {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		String username = request.getParameter("loginName");
		String password = request.getParameter("password");
		String captcha = request.getParameter("captcha");
		CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
				username, password, true, request.getRemoteHost(), captcha);
		ModelAndView modelAndView = new ModelAndView();
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			// 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			System.out.println("对用户[" + username + "]进行登录验证..验证开始");
			currentUser.login(token);
			System.out.println("对用户[" + username + "]进行登录验证..验证通过");

		} catch (UnknownAccountException uae) {
			System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
			request.setAttribute("message_login", "未知账户");
		} catch (IncorrectCredentialsException ice) {
			System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
			request.setAttribute("message_login", "密码不正确");
		} catch (LockedAccountException lae) {
			System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
			request.setAttribute("message_login", "账户已锁定");
		} catch (ExcessiveAttemptsException eae) {
			System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
			request.setAttribute("message_login", "用户名或密码错误次数过多");
		} catch (AuthenticationException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
			ae.printStackTrace();
			request.setAttribute("message_login", "用户名或密码不正确");
		}
		// 验证是否登录成功
		if (currentUser.isAuthenticated()) {
			// if (currentUser.hasRole("user")) {
			// try {
			// currentUser.checkPermission("view");
			// modelAndView.setViewName("user/userDetail");
			// modelAndView.addObject("userName", username);
			// modelAndView.addObject("password", password);
			// } catch (Exception e) {
			// System.out.println("用户[" + username + "]没有查看权限");
			// return null;
			// }
			// try {
			// currentUser.checkPermission("add");
			// modelAndView.setViewName("user/addUser");
			// modelAndView.addObject("userName", username);
			// modelAndView.addObject("password", password);
			// } catch (Exception e) {
			// System.out.println("用户[" + username + "]没有新增权限");
			// return null;
			// }
			//
			// }
			// if (currentUser.hasRole("admin")) {
			// try {
			// currentUser.checkPermission("view");
			// modelAndView.setViewName("admin/adminDetail");
			// modelAndView.addObject("userName", username);
			// modelAndView.addObject("password", password);
			// } catch (Exception e) {
			// System.out.println("用户[" + username + "]没有查看权限");
			// return null;
			// }
			// try {
			// currentUser.checkPermission("add");
			// modelAndView.setViewName("admin/addAdmin");
			// modelAndView.addObject("userName", username);
			// modelAndView.addObject("password", password);
			// } catch (Exception e) {
			// System.out.println("用户[" + username + "]没有新增权限");
			// return null;
			// }
			// }
			//
			// } else {
			// token.clear();
			// modelAndView.setViewName("login");
			modelAndView.addObject("userName", username);
			modelAndView.addObject("password", password);
			modelAndView.setViewName("index");
			return modelAndView;
		}
		// if (loginName == null || "".equals(loginName)) {
		modelAndView.setViewName("login");
		// return modelAndView;
		// }
		return modelAndView;
	}
}
