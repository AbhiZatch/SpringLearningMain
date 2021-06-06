package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLang;
	private String programmingSystems[];
	
	private LinkedHashMap<String,String> countryOptions;
	
	public Student() {
		
		
		//populate country options
		
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR","Brazil");
		countryOptions.put("IN","India");
		countryOptions.put("US","United States of America ");
		countryOptions.put("UK","United Kingdom");
	}
	
	
	public String[] getProgrammingSystems() {
		return programmingSystems;
	}



	public void setProgrammingSystems(String[] programmingSystems) {
		this.programmingSystems = programmingSystems;
	}

	public String getFavoriteLang() {
		return favoriteLang;
	}



	public void setFavoriteLang(String favoriteLang) {
		this.favoriteLang = favoriteLang;
	}



	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
