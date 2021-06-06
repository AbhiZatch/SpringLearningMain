package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {

	private String firstName;
	
	@CourseCode
	private String courseCode;

	@NotNull(message="is Required")
	@Pattern(regexp = "[a-zA-Z0-9]{5}",message="Only 5 Characters Allowed")
	private String postalCode;
	
	@NotNull(message="is Required")
	@Min(value=0,message="Value should be greater than 0")
	@Max(value=10,message="Value should be less than 10")
	private Integer freePasses;

	@NotNull(message="is Required")
	@Size(min=1,message="is Required")
	private String lastName;


	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	
	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
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
