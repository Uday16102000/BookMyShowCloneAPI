package com.jsp.CloneApIBookMyShow.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jsp.CloneApIBookMyShow.enums.ScreenAvailability;
import com.jsp.CloneApIBookMyShow.enums.ScreenStatus;
import com.jsp.CloneApIBookMyShow.enums.ScreenType;
@Entity
public class Screen {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private long screenId;
private String screenName;
//screenType==>enum
private ScreenType screentype;
//screenAvailability==>enum
private ScreenAvailability screenAvailability;
//screenStatus==>enum
private ScreenStatus screenStatus;
@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
private List<Seat> seats;
private int noOfClassicSeat;
private int noOfPlatinumSeat;
private int noOfGoldSeat;

@ManyToOne
private Theatre theatre;

public ScreenType getScreentype() {
	return screentype;
}

public void setScreentype(ScreenType screentype) {
	this.screentype = screentype;
}

public ScreenAvailability getScreenAvailability() {
	return screenAvailability;
}

public void setScreenAvailability(ScreenAvailability screenAvailability) {
	this.screenAvailability = screenAvailability;
}



public ScreenStatus getScreenStatus() {
	return screenStatus;
}

public void setScreenStatus(ScreenStatus screenStatus) {
	this.screenStatus = screenStatus;
}

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

public List<Seat> getSeats() {
	return seats;
}

public void setSeats(List<Seat> seats) {
	this.seats = seats;
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

public Theatre getTheatre() {
	return theatre;
}

public void setTheatre(Theatre theatre) {
	this.theatre = theatre;
}


}
