package com.jsp.CloneApIBookMyShow.exception;

public class AddressIdNotFoundException extends RuntimeException {

	private String message;

	public AddressIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
