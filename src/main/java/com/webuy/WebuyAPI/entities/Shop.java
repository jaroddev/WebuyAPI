package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Shop implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address address;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private ImagesPointer images;

	@ManyToOne
	private ShopGroup shopGroup;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "shopId")
	private Collection<Product> products;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "shopId")
	private Collection<Offer> offers;

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

	public Collection<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Collection<Offer> offers) {
		this.offers = offers;
	}

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

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(Long productId) {
		for (Product product : products)
			if (product.getId().equals(productId))
				products.remove(product);
	}

	public void addImage(Image image) {
		if (this.images.getImages().size() <= 3)
			this.images.getImages().add(image);
	}

	public void removeImage(Long imageId) {
		this.images.removeImage(imageId);
	}

}
