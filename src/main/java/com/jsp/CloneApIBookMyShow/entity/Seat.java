package com.jsp.CloneApIBookMyShow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.jsp.CloneApIBookMyShow.enums.SeatType;

@Entity
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seatId;

	
	//seatType
	
	private SeatType seatType;
	@ManyToOne
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
