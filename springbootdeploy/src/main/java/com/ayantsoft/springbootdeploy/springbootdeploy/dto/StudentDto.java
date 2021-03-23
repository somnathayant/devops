package com.ayantsoft.springbootdeploy.springbootdeploy.dto;

import java.io.Serializable;

import javax.persistence.Column;

public class StudentDto implements Serializable{

	/**
	 * serialVersionUID = -8651259580361478593L;
	 */
	private static final long serialVersionUID = -8651259580361478593L;
	private Long id;
	private String firstName;
	private String lastName;
	private String year;
	private Integer add_id;
	private String city;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Integer getAdd_id() {
		return add_id;
	}
	public void setAdd_id(Integer add_id) {
		this.add_id = add_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
	
}
