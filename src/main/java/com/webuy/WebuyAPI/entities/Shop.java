package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Shop implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String image;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Address address;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private ShopGroup group;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "shopId")
	private List<Product> products = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "offerId")
	private List<Offer> offers = new ArrayList<>();
	
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
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}	
	
	public void addProduct(Product product) {
		products.add(product);
    }
 
    public void removeProduct(Long productId) {
    	for(Product product : products)
    		if(product.getId().equals(productId)) products.remove(product);
    }
	
}
