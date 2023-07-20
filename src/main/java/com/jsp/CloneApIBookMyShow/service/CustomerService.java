package com.jsp.CloneApIBookMyShow.service;

import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApIBookMyShow.dao.CustomerDao;
import com.jsp.CloneApIBookMyShow.dto.CustomerDto;
import com.jsp.CloneApIBookMyShow.entity.Address;
import com.jsp.CloneApIBookMyShow.entity.Customer;
import com.jsp.CloneApIBookMyShow.exception.AddressIdNotFoundException;
import com.jsp.CloneApIBookMyShow.exception.CustomerIdNotFoundException;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;

@Service
public class CustomerService {
  
	
	@Autowired
	private CustomerDao dao;
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<ResponseStructure<CustomerDto>> saveCustomer(Customer customer) {
	Customer customer1=this.modelMapper.map(customer, Customer.class);
	Customer dbcustomer= dao.saveCustomer(customer);
	ResponseStructure<CustomerDto> structure = new ResponseStructure<CustomerDto>();
	structure.setMessage("Customer saved successfully");
	structure.setStatus(HttpStatus.CREATED.value());
	structure.setData(dbcustomer);
	
		return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(long customerId) {
	Customer dbCustomer= dao.deleteCustomerById(customerId);
		
		if(dbCustomer!=null)
		{
			ResponseStructure<Customer> structure =  new ResponseStructure<Customer>();
			structure.setMessage("Customer deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbCustomer);
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
		}else {
			throw new CustomerIdNotFoundException("Sorry failed to delete Customer");
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomer(long customerId) {
	 Customer dbCustomer=dao.fetchCustomerById(customerId);
	 if(dbCustomer!=null)
	 {
		 ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
		 structure.setMessage("Customer fetched successfully");
		 structure.setStatus(HttpStatus.FOUND.value());
		 structure.setData(dbCustomer);
		 return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
		 
	 }else {
		 throw new CustomerIdNotFoundException("Sorry failed to find customer by given Id");
	 }
	}

	

	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(long customerId, Customer customer) {
	   Customer dbCustomer= dao.updateCustomerById(customerId, customer);
	   if(customer!=null)
	   {

			 ResponseStructure<CustomerDto> structure = new ResponseStructure<CustomerDto>();
			 structure.setMessage("Customer updated successfully");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(dbCustomer);
			 return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.FOUND);
			 
		 }else {
			 throw new CustomerIdNotFoundException("Sorry failed to update customer by given Id");
		 }
	   
	}
}
