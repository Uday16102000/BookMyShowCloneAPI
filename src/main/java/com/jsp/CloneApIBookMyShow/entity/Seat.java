package com.jsp.CloneApIBookMyShow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.CloneApIBookMyShow.enums.SeatType;

@Entity
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seatId;

	
	//seatType
	
	private SeatType seatType;
	public SeatType getSeatType() {
		return seatType;
	}


	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}


	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Screen screen;


	public long getSeatId() {
		return seatId;
	}


	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}


	public Screen getScreen() {
		return screen;
	}


	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	

}
