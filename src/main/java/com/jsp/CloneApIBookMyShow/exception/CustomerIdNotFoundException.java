package com.jsp.CloneApIBookMyShow.exception;

public class CustomerIdNotFoundException extends RuntimeException {
 String message;

public CustomerIdNotFoundException(String message) {
	super();
	this.message = message;
}
 
}
