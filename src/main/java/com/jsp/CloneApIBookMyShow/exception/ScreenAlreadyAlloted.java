package com.jsp.CloneApIBookMyShow.exception;

public class ScreenAlreadyAlloted extends RuntimeException {
	String message;

	public ScreenAlreadyAlloted(String message) {
		super();
		this.message = message;
	}
	

}
