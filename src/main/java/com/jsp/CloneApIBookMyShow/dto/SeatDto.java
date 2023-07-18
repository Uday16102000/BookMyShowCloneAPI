package com.jsp.CloneApIBookMyShow.dto;

import com.jsp.CloneApIBookMyShow.entity.Screen;

public class SeatDto 
{

	private long seatId;

	
	//seatType

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
