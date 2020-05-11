package com.webuy.WebuyAPI.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webuy.WebuyAPI.dao.ProductJPARepository;
import com.webuy.WebuyAPI.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductJPARepository repo;

	@Override
	public Collection<Product> getProducts() {
		return repo.findAll();
	}

	@Override
	public Product getOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void createProduct(Product product) {
		repo.saveAndFlush(product);
	}

	@Override
	public void updateProduct(Long id, Product product) {
		repo.saveAndFlush(product);
		
	}

	@Override
	public void deleteProduct(Long id) {
		repo.deleteById(id);
	}
	
}
