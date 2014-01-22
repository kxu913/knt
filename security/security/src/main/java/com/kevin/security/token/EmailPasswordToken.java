package com.kevin.security.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * use emailaddress and password to create token
 * 
 * @author kevin
 * 
 */
public class EmailPasswordToken extends UsernamePasswordToken {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmailPasswordToken(String username, String password,
			boolean rememberMe, String host, String email) {
		super(username, password, rememberMe, host);
		this.email = email;
	}
}
