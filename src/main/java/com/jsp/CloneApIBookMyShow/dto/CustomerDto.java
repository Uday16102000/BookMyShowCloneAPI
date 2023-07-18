package com.jsp.CloneApIBookMyShow.dto;

import java.util.List;

import com.jsp.CloneApIBookMyShow.entity.Ticket;

public class CustomerDto {
	private long customerId;
	private String customerName;
	private long customerPhone;
	private String customerEmail;
//	private String customerPassword;

	private List<Ticket> tickets;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
//	public String getCustomerPassword() {
//		return customerPassword;
//	}
//	public void setCustomerPassword(String customerPassword) {
//		this.customerPassword = customerPassword;
//	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
}
