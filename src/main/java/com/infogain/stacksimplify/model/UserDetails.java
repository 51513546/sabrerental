package com.infogain.stacksimplify.model;

public class UserDetails {
	private String cityName;
	private String firstName;
	private String lastName;
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetails(String firstName, String lastName, String cityName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cityName = cityName;
	}
	public String getCityName() {
		return cityName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "UserDetails [firstName=" + firstName + ", lastName=" + lastName + ", cityName=" + cityName + "]";
	}
	

}
