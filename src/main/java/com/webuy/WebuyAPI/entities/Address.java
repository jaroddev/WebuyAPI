package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

@Entity
public class Address implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String city;
	private String postalCode;
	private String department;
	private String country;

	@OneToOne
	private GPSLocationPointer gpsLocationPointer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public GPSLocationPointer getGPSLocationPointer() {
		return gpsLocationPointer;
	}

	public void setGPSLocationPointer(GPSLocationPointer gpsLocationPointer) {
		this.gpsLocationPointer = gpsLocationPointer;
	}

}
