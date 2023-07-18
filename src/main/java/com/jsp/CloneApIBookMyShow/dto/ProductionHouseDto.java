package com.jsp.CloneApIBookMyShow.dto;

import java.time.LocalDate;
import java.util.List;

import com.jsp.CloneApIBookMyShow.entity.Movie;
import com.jsp.CloneApIBookMyShow.entity.Owner;

public class ProductionHouseDto 
{
	private long productionId;
	private String productionName;
	private LocalDate establishment;

	private Owner owner;

	private List<Movie> movies;
	public long getProductionId() {
		return productionId;
	}
	public void setProductionId(long productionId) {
		this.productionId = productionId;
	}
	public String getProductionName() {
		return productionName;
	}
	public void setProductionName(String productionName) {
		this.productionName = productionName;
	}
	public LocalDate getEstablishment() {
		return establishment;
	}
	public void setEstablishment(LocalDate establishment) {
		this.establishment = establishment;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
