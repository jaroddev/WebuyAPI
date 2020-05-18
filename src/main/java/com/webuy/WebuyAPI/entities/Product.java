package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Product implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private double price;
	private int stock;

	@OneToOne
	private Image logo;

	public Long getId() {
		return id;
	}

	/*public void setId(Long id) {
	this.id = id;
}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

}
