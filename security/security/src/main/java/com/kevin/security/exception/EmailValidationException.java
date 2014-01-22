package com.kevin.security.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 验证码exception
 * 
 * @author kevin
 * 
 */
public class EmailValidationException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailValidationException() {
		super();
	}

	public EmailValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailValidationException(String message) {
		super(message);
	}

	public EmailValidationException(Throwable cause) {
		super(cause);
	}
}
