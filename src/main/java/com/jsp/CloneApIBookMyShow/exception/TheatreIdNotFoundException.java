package com.jsp.CloneApIBookMyShow.exception;

public class TheatreIdNotFoundException extends RuntimeException {
String message;

public TheatreIdNotFoundException(String message) {
	super();
	this.message = message;
}

}
