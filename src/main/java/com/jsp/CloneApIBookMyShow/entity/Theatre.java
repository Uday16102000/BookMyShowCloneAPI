package com.jsp.CloneApIBookMyShow.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Theatre 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long theatreId;
	private String theatreName;
	@OneToOne
	@JoinColumn
	private Address address;
	
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "theatre", fetch = FetchType.EAGER)
	private List<Screen> screen;
	
	@ManyToOne
	@JoinColumn
	private Owner owner;
	
	@OneToMany
	private List<MovieShow> movieshows;

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

	public List<MovieShow> getMovieshows() {
		return movieshows;
	}

	public void setMovieshows(List<MovieShow> movieshows) {
		this.movieshows = movieshows;
	}

	
	
	
	
}
