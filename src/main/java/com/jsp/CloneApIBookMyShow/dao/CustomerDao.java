package com.jsp.CloneApIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneApIBookMyShow.entity.Customer;
import com.jsp.CloneApIBookMyShow.repository.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepo repo;
	
	public Customer saveCustomer(Customer customer) {
		 Customer dbcustomer=  repo.save(customer);
		   return dbcustomer;
		}

		public Customer updateCustomerById(long customerId, Customer customer) {
			Optional<Customer> dbcustomer= repo.findById(customerId);
			if(dbcustomer.isPresent())
			{
				customer.setCustomerId(customerId);
				repo.save(customer);
				return customer;
			}
			
			return null;
		}

		public Customer fetchCustomerById(long customerId) {
			Optional<Customer> optional= repo.findById(customerId);
			if(optional.isPresent())
			{
				return optional.get();
			}else {
				return null;
			}
		}

		public Customer deleteCustomerById(long customerId) {
			   Optional<Customer> optional= repo.findById(customerId);
			   if(optional.isPresent())
			   {
				   repo.delete(optional.get());
				   return optional.get();
			   }
			   return null;
		}



}
