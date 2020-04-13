package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String phoneNumber;
	private String password;
	private String role;
	private Address address;
	private Collection<User> friends;
	
	
}
