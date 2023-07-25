package com.jsp.CloneApIBookMyShow.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.CloneApIBookMyShow.enums.Genres;
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movieId;
	private String movieName;
	//genress
	private Genres genre1;
	private Genres genre2;
	private Genres genre3;
//	@DateTimeFormat(style = "HH:mm")
    @JsonFormat(pattern = "HH:mm")
	private LocalDateTime movieDuration;
	private String movieDescription;
	private String language;
	@ManyToOne
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
