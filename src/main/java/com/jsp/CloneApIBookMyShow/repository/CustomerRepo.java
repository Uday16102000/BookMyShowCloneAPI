package com.jsp.CloneApIBookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneApIBookMyShow.entity.Customer;

public interface CustomerRepo  extends JpaRepository<Customer, Long>{

}
