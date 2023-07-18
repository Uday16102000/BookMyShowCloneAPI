package com.jsp.CloneApIBookMyShow.dto;

import java.time.LocalDateTime;

import com.jsp.CloneApIBookMyShow.enums.BookingStatus;
import com.jsp.CloneApIBookMyShow.enums.SeatType;

public class BookingDto
{
	private long bookingId;
	private LocalDateTime bookingFromTime;
	private LocalDateTime bookingTillTime;
	private long seatId;
	//seatType
		private SeatType seatType;
		//booking status
		private BookingStatus status;
	private double seatPrice;
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDateTime getBookingFromTime() {
		return bookingFromTime;
	}
	public void setBookingFromTime(LocalDateTime bookingFromTime) {
		this.bookingFromTime = bookingFromTime;
	}
	public LocalDateTime getBookingTillTime() {
		return bookingTillTime;
	}
	public void setBookingTillTime(LocalDateTime bookingTillTime) {
		this.bookingTillTime = bookingTillTime;
	}
	public long getSeatId() {
		return seatId;
	}
	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}
	public double getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	
}
