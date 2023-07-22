package com.jsp.CloneApIBookMyShow.dto;

import java.util.List;

import com.jsp.CloneApIBookMyShow.entity.Seat;
import com.jsp.CloneApIBookMyShow.entity.Theatre;
import com.jsp.CloneApIBookMyShow.enums.ScreenAvailability;
import com.jsp.CloneApIBookMyShow.enums.ScreenStatus;
import com.jsp.CloneApIBookMyShow.enums.ScreenType;

public class ScreenDto 
{
	private long screenId;
	private String screenName;
	//screenType==>enum
	//screenAvailability==>enum
	//screenStatus==>enum
	//screenType==>enum
	private ScreenType screentype;
	//screenAvailability==>enum
	private ScreenAvailability screenAvailability;
	//screenStatus==>enum
	private ScreenStatus screenSttaus;

//	private List<Seat> seats;
	private int noOfClassicSeat;
	private int noOfPlatinumSeat;
	private int noOfGoldSeat;


	

	public long getScreenId() {
		return screenId;
	}

	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}



	public int getNoOfClassicSeat() {
		return noOfClassicSeat;
	}

	public void setNoOfClassicSeat(int noOfClassicSeat) {
		this.noOfClassicSeat = noOfClassicSeat;
	}

	public int getNoOfPlatinumSeat() {
		return noOfPlatinumSeat;
	}

	public void setNoOfPlatinumSeat(int noOfPlatinumSeat) {
		this.noOfPlatinumSeat = noOfPlatinumSeat;
	}

	public int getNoOfGoldSeat() {
		return noOfGoldSeat;
	}

	public void setNoOfGoldSeat(int noOfGoldSeat) {
		this.noOfGoldSeat = noOfGoldSeat;
	}

	

}
