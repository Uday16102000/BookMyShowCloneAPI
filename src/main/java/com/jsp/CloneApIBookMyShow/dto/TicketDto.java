package com.jsp.CloneApIBookMyShow.dto;

import java.util.List;

import com.jsp.CloneApIBookMyShow.entity.Booking;
import com.jsp.CloneApIBookMyShow.entity.Customer;
import com.jsp.CloneApIBookMyShow.entity.MovieShow;
import com.jsp.CloneApIBookMyShow.enums.TicketStatus;

public class TicketDto 
{
	private int ticketId;
	private double totalPrice;
	//Ticket status
	private TicketStatus ticketstatus;

	private MovieShow show;
	
	  private List<Booking> bookings;
	  
  
	  private Customer customer;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public MovieShow getShow() {
		return show;
	}

	public void setShow(MovieShow show) {
		this.show = show;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	  
}
