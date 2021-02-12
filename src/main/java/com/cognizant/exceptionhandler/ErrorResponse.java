package com.cognizant.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	private String code;
	private HttpStatus status;
	private String description;
	private LocalDateTime timestamp;

	public ErrorResponse(String code, HttpStatus status, String description, LocalDateTime timestamp) {
		this.code = code;
		this.status = status;
		this.description = description;
		this.timestamp = timestamp;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return description;
	}

	public void setMessage(String description) {
		this.description = description;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
}
