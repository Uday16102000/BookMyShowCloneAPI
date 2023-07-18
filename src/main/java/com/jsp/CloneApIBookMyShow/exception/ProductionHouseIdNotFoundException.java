package com.jsp.CloneApIBookMyShow.exception;

public class ProductionHouseIdNotFoundException  extends RuntimeException{
	
	private String message;

	public ProductionHouseIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	

}
