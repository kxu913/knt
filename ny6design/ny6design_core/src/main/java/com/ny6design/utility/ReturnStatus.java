package com.ny6design.utility;


import java.io.Serializable;
/**
 * 
 * @author kevin
 *
 */
public class ReturnStatus implements Serializable{
	
	private static final long serialVersionUID = 5125965356358329466L;
	
	public static final int SUCCESS_CODE = 0;
	
	public static final int FAILURE = -1;
	
	public static final String SUCCESS = "Success";
	
	public static final String RESULT = "Result";
	
	public static final String STATUS = "Code";
	
	public static final String MESSAGE = "Message";
}
