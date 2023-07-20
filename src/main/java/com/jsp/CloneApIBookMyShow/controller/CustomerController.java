package com.jsp.CloneApIBookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.CloneApIBookMyShow.dto.CustomerDto;
import com.jsp.CloneApIBookMyShow.entity.Customer;
import com.jsp.CloneApIBookMyShow.service.CustomerService;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(@RequestBody Customer customer){
		return service.saveCustomer(customer);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(@RequestParam long customerId, @RequestBody Customer customer){
		return service.updateCustomer(customerId, customer);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam long customerId){
		return service.deleteCustomer(customerId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Customer>> getCustomer(@RequestParam long customerId){
		return service.getCustomer(customerId);
	}}
