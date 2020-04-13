package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class GroupInvite implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private User sender;
	private User recipient;
	private Group group;
	private String message;
	
	
}
