package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

@Entity
public class Shop implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String image;
	private Address address;
	@OneToMany
	private Collection<Offer> offers;
	@OneToMany
	private Collection<Product> products;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Collection<Offer> getOffers() {
		return offers;
	}
	
	public void setOffers(Collection<Offer> offers) {
		this.offers = offers;
	}

	public Collection<Product> getProducts() {
		return products;
	}
	
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
}
