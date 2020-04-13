package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Group implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int validity;
	private User leader;
	private Collection<User> members;
	private Collection<GroupMessage> messages;
	private Offer offer;
	
	
}
