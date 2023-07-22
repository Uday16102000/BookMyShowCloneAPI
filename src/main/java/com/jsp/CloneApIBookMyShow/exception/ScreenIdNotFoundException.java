package com.jsp.CloneApIBookMyShow.exception;

public class ScreenIdNotFoundException extends RuntimeException {
String message;

public ScreenIdNotFoundException(String message) {
	super();
	this.message = message;
	
}

}
