package com.webuy.WebuyAPI.services;

import java.util.Collection;

import com.webuy.WebuyAPI.entities.Product;

public interface ProductService {
	public abstract Collection<Product> getAll();
	public abstract Product getOne(Long id);
	public abstract void createProduct(Product product);
	public abstract void updateProduct(Long id, Product product);
	public abstract void deleteProduct(Long id);
}
