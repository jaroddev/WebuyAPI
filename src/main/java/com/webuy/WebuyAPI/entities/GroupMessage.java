package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class GroupMessage implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private User sender;
	private String sendDate;
	private String content;
	
	
}
