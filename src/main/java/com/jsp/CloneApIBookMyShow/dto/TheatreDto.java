package com.jsp.CloneApIBookMyShow.dto;

import java.util.List;

import javax.persistence.JoinColumn;

import com.jsp.CloneApIBookMyShow.entity.Address;
import com.jsp.CloneApIBookMyShow.entity.MovieShow;
import com.jsp.CloneApIBookMyShow.entity.Owner;
import com.jsp.CloneApIBookMyShow.entity.Screen;


public class TheatreDto 
{
	private long theatreId;
	private String theatreName;
	
	private Address address;
	
	
	
	private List<Screen> screen;
	
	
	private Owner owner;
	
	
	private List<MovieShow> shows;

	public long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(long theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Screen> getScreen() {
		return screen;
	}

	public void setScreen(List<Screen> screen) {
		this.screen = screen;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<MovieShow> getShows() {
		return shows;
	}

	public void setShows(List<MovieShow> shows) {
		this.shows = shows;
	}
	
	
}
