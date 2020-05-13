package com.webuy.WebuyAPI.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webuy.WebuyAPI.entities.Product;
import com.webuy.WebuyAPI.services.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;

	@GetMapping("/product")
	public Collection<Product> getShopList(){
		return this.productService.getAll();
	}
	
	@PostMapping("/product")
	public void addShop(@RequestBody Product product) {
		this.productService.createProduct(product);
	}
	
	@PutMapping("/product")
	public void editShop(@PathVariable Long id, @RequestBody Product product) {
		this.productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/product")
	public void deleteShop(@PathVariable Long id) {
		this.productService.deleteProduct(id);
	}
	
}
