package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Product implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int stock;
	
	
}
