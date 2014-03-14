package com.ny6design.exception;

/**
 * 
 * @author kevin
 *
 */
public class DeleteForbiddenException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteForbiddenException(String message){
		super(message);
	}

}
