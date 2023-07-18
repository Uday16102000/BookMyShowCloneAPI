package com.jsp.CloneApIBookMyShow.dto;

import com.jsp.CloneApIBookMyShow.entity.Theatre;

public class AddressDto {

	private long addressId;
	private int FlatNo;
	private String area;
	private String landmark;
	private String city;
	private String state;
	private String country;
	private long pincode;

	private Theatre theatre;
	
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public int getFlatNo() {
		return FlatNo;
	}
	public void setFlatNo(int flatNo) {
		FlatNo = flatNo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
}
