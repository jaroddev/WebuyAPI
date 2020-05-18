package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private double price;
	private int stock;

	@OneToOne(cascade = CascadeType.PERSIST)
	private ImagesPointer images;

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

	public ImagesPointer getImages() {
		return images;
	}

	public void setImages(ImagesPointer images) {
		this.images = images;
	}

	public void addImage(Image image) {
		this.images.addImage(image);
	}

	public void removeImage(Long imageId) {
		this.images.removeImage(imageId);
	}

}
