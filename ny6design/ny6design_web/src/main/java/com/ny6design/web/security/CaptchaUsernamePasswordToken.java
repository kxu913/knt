package com.ny6design.web.security;

import org.apache.shiro.authc.UsernamePasswordToken;
/**
 * 
 * @author kevin
 *
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String captcha;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	} 
	public CaptchaUsernamePasswordToken(String username, String password, 
			 boolean rememberMe, String host,String captcha) { 
			 super(username, password, rememberMe, host); 
			 this.captcha = captcha; 
			 } 
}
