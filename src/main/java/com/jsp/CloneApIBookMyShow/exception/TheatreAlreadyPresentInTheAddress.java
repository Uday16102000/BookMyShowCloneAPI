package com.jsp.CloneApIBookMyShow.exception;

public class TheatreAlreadyPresentInTheAddress  extends RuntimeException{

	String message;

	public TheatreAlreadyPresentInTheAddress(String message) {
		super();
		this.message = message;
	}
	
}
