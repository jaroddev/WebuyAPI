package com.webuy.WebuyAPI.dto;

import java.util.Set;

import com.webuy.WebuyAPI.entities.Address;
import com.webuy.WebuyAPI.entities.ImagesPointer;
import com.webuy.WebuyAPI.entities.ShopGroup;

public class ShopDTO {

	private Long id;

	private Address address;

	private ImagesPointer images;

	private ShopGroup shopGroup;

	private Set<Long> addedProducts;
	private Set<Long> removedProducts;

	// private Set<Long> addedOffers;
	// private Set<Long> removedOffers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ImagesPointer getImages() {
		return images;
	}

	public void setImages(ImagesPointer images) {
		this.images = images;
	}

	public ShopGroup getShopGroup() {
		return shopGroup;
	}

	public void setShopGroup(ShopGroup shopGroup) {
		this.shopGroup = shopGroup;
	}

	public Set<Long> getAddedProducts() {
		return addedProducts;
	}

	public void setAddedProducts(Set<Long> addedProducts) {
		this.addedProducts = addedProducts;
	}

	public Set<Long> getRemovedProducts() {
		return removedProducts;
	}

	public void setRemovedProducts(Set<Long> removedProducts) {
		this.removedProducts = removedProducts;
	}

}
