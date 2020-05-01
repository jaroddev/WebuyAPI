package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;

@Entity
public class Offer implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private int minMemberCount;

	private int maxMemberCount;

	private Date start;

	private Date end;

	private int stock;

	@OneToOne
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

	public void setMinMemberCount(int minMemberCount) {
		this.minMemberCount = minMemberCount;
	}

	public int getMaxMemberCount() {
		return maxMemberCount;
	}

	public void setMaxMemberCount(int maxMemberCount) {
		this.maxMemberCount = maxMemberCount;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
