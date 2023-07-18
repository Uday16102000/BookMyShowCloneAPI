package com.jsp.CloneApIBookMyShow.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class ProductionHouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productionId;
	private String productionName;
	private LocalDate establishment;
	@ManyToOne
	@JoinColumn
	private Owner owner;
	@OneToMany(fetch = FetchType.EAGER)
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
