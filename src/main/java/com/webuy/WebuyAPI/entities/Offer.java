package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Offer implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private int minMemberCount;
	private int maxMemberCount;
	private String createDate;
	private String endDate;
	private int stock;
	private Product product;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getMinMemberCount() {
		return minMemberCount;
	}
	
	
}
