package com.infogain.stacksimplify.exception;

import java.util.Date;

public class CustomErrorDetails {
	
	private Date timestamps;
	private String message;
	private String errorDetails;
	
	//Fields CVonstructor
	public CustomErrorDetails(Date timestamps, String message, String errorDetails) {
		super();
		this.timestamps = timestamps;
		this.message = message;
		this.errorDetails = errorDetails;
	}
	public CustomErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getTimestamps() {
		return timestamps;
	}
	public String getMessage() {
		return message;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	
	
	

}
