package com.cognizant.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorResponse exceptionResponse = new ErrorResponse(String.valueOf(HttpStatus.FORBIDDEN.value()),
				HttpStatus.FORBIDDEN, ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.FORBIDDEN);
	}
}
