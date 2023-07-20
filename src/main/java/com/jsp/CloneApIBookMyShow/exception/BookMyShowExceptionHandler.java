package com.jsp.CloneApIBookMyShow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.CloneApIBookMyShow.util.ResponseStructure;

@RestControllerAdvice
public class BookMyShowExceptionHandler  extends ResponseEntityExceptionHandler
{

	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ownerIdNotFound(OwnerIdNotFoundException ex)
	{
		ResponseStructure<String> structure= new ResponseStructure<String>();
		structure.setMessage("ID not found for owner");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> houseIdNoTFound(ProductionHouseIdNotFoundException ex){
		ResponseStructure<String>  structure=new ResponseStructure<String>();
		structure.setMessage("Id NOt Found for ProductionHouse");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> AddressIdNoTFound(AddressIdNotFoundException ex){
		ResponseStructure<String>  structure=new ResponseStructure<String>();
		structure.setMessage("Id NOt Found for ProductionHouse");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TheatreAlreadyExist(TheatreAlreadyPresentInTheAddress ex){
		ResponseStructure<String>  structure=new ResponseStructure<String>();
		structure.setMessage("Theatre Already Present in the address");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TheatreIdNotFound(TheatreIdNotFoundException ex){
		ResponseStructure<String>  structure=new ResponseStructure<String>();
		structure.setMessage("Theatre  Already delted ");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> CustomerIdNotFound(CustomerIdNotFoundException ex){
		ResponseStructure<String>  structure=new ResponseStructure<String>();
		structure.setMessage("Customer Id Not Found  ");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
