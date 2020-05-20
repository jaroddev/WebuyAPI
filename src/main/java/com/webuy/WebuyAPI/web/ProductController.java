package com.webuy.WebuyAPI.web;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webuy.WebuyAPI.dao.ProductJPARepository;
import com.webuy.WebuyAPI.entities.Product;


@RestController
public class ProductController {
	
	@Autowired
	private ProductJPARepository productJpaRepository;

	@GetMapping("/products")
	public Collection<Product> getAllProducts(){
		return this.productJpaRepository.findAll();
	}
	
	@GetMapping("products/{id}")
	public Product getProductById(Long id)
	{
		Product product = null;

		Optional<Product> productOptional = productJpaRepository.findById(id);
		if (productOptional.isPresent()) {
			product = productJpaRepository.findById(id).get();
		}

		return product;
	}
	
	@PostMapping("/products")
	public void createProduct(@RequestBody Product product) {
		this.productJpaRepository.save(product);
	}
	
	@PutMapping("/products/{id}")
	public void updateProduct(@PathVariable Long id, @RequestBody Product newProduct) 
	{
		Product oldProduct = getProductById(id);
		if(oldProduct.getId().equals(newProduct.getId()))
				this.productJpaRepository.save(newProduct);
	}
	
	@PutMapping("/products")
	public void updateProduct(@RequestBody Product newProduct) 
	{
			this.productJpaRepository.save(newProduct);
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteShop(@PathVariable Long id) {
		this.productJpaRepository.deleteById(id);
	}
	
}
