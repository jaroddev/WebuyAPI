package com.webuy.WebuyAPI.dto;

import com.webuy.WebuyAPI.entities.ImagesPointer;

public class ProductDTO {

	private Long id;
	private String name;
	private double price;
	private int stock;

	private ImagesPointer images;

	private Long shopId;

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

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

}
