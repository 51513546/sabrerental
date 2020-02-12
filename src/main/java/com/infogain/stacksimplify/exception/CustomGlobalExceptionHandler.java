package com.infogain.stacksimplify.exception;

import java.util.Date;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	//handleMethodArgumentNotValid
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
      CustomErrorDetails ERRORDETAILS=new CustomErrorDetails(new Date(),"Method Argument not valid exception from GEH",ex.getMessage());
		return new ResponseEntity<>(ERRORDETAILS,HttpStatus.BAD_REQUEST);
	}//handleMethodArgumentNotValid
	
	
	
	//handleHttpRequestMethodNotSupported	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		pageNotFoundLogger.warn(ex.getMessage());

		CustomErrorDetails ERRORDETAILS=new CustomErrorDetails(new Date(),"Method Not Allowed",ex.getMessage());
		return new ResponseEntity<>(ERRORDETAILS,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(UserNameNotFoundException.class)
	public final ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException e,WebRequest request){
		CustomErrorDetails ERRORDETAILS=new CustomErrorDetails(new Date(),e.getLocalizedMessage(),request.getDescription(false));
		return new ResponseEntity<>(ERRORDETAILS,HttpStatus.NOT_FOUND);
	}

}
