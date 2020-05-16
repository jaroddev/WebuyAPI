package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	
	// For authentication
	private String email;
	private String phoneNumber;
	private String password;
	private String role;

	// Shop recommendation
	@OneToOne(cascade= CascadeType.PERSIST)
	private Address address;

	// Define the user to other user
	private String name;
	
	@ManyToMany
	private Collection<User> friends;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name ;
	}

	public Collection<User> getFriends() {
		return friends;
	}

	public void setFriends(Collection<User> friends) {
		this.friends = friends;
	}

}
