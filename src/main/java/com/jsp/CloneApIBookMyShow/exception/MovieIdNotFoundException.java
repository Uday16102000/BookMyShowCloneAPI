package com.jsp.CloneApIBookMyShow.exception;

public class MovieIdNotFoundException extends RuntimeException {
	String message;

	public MovieIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	

}
