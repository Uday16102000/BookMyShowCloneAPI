package com.jsp.CloneApIBookMyShow.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.jsp.CloneApIBookMyShow.enums.Genres;
import com.jsp.CloneApIBookMyShow.enums.ShowStatus;
@Entity
public class MovieShow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long showId;
	private LocalDateTime showStartTime;
	private LocalDateTime showEndTime;
	private String genre;
	
	//showstatus
	private ShowStatus showstatus;
	private String showLocation;
	
	private long movieId;
	private String movieName;
	//genre
	private Genres genre1;
	private Genres genre2;
	private Genres genre3;
	private LocalDateTime movieDuration;
	private String movieDescription;
	private String movieLanguage;
	
	private long screenId;
	private String screenName;
	private double classicSeatPrice;
	private double goldSeatPrice;
	private double premiumSeatPrice;
@ManyToOne	
private Theatre theatre;
public long getShowId() {
	return showId;
}
public void setShowId(long showId) {
	this.showId = showId;
}
public LocalDateTime getShowStartTime() {
	return showStartTime;
}
public void setShowStartTime(LocalDateTime showStartTime) {
	this.showStartTime = showStartTime;
}
public LocalDateTime getShowEndTime() {
	return showEndTime;
}
public void setShowEndTime(LocalDateTime showEndTime) {
	this.showEndTime = showEndTime;
}
public String getShowLocation() {
	return showLocation;
}
public void setShowLocation(String showLocation) {
	this.showLocation = showLocation;
}
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
public String getMovieLanguage() {
	return movieLanguage;
}
public void setMovieLanguage(String movieLanguage) {
	this.movieLanguage = movieLanguage;
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
public double getClassicSeatPrice() {
	return classicSeatPrice;
}
public void setClassicSeatPrice(double classicSeatPrice) {
	this.classicSeatPrice = classicSeatPrice;
}
public double getGoldSeatPrice() {
	return goldSeatPrice;
}
public void setGoldSeatPrice(double goldSeatPrice) {
	this.goldSeatPrice = goldSeatPrice;
}
public double getPremiumSeatPrice() {
	return premiumSeatPrice;
}
public void setPremiumSeatPrice(double premiumSeatPrice) {
	this.premiumSeatPrice = premiumSeatPrice;
}
public Theatre getTheatre() {
	return theatre;
}
public void setTheatre(Theatre theatre) {
	this.theatre = theatre;
}







}
