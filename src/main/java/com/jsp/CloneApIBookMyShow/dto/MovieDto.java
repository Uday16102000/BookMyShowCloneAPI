package com.jsp.CloneApIBookMyShow.dto;

import java.time.LocalDateTime;

import com.jsp.CloneApIBookMyShow.entity.ProductionHouse;
import com.jsp.CloneApIBookMyShow.enums.Genres;

public class MovieDto 
{

	private long movieId;
	private String movieName;
	//genress
	private Genres genre1;
	private Genres genre2;
	private Genres genre3;
	private LocalDateTime movieDuration;
	private String movieDescription;
	private String language;

	private ProductionHouse productionHouse;
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalDateTime getMovieDuration() {
		return movieDuration;
	}
	public void setMovieDuration(LocalDateTime movieDuration) {
		this.movieDuration = movieDuration;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public ProductionHouse getProductionHouse() {
		return productionHouse;
	}
	public void setProductionHouse(ProductionHouse productionHouse) {
		this.productionHouse = productionHouse;
	}
	
}
