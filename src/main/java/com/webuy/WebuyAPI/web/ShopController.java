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

import com.webuy.WebuyAPI.dao.ShopJPARepository;

import com.webuy.WebuyAPI.entities.Shop;


@RestController
public class ShopController {
	
	@Autowired
	ShopJPARepository shopJpaRepository;
	
	@GetMapping("/shops")
	public Collection<Shop> getAllShops(){
		return this.shopJpaRepository.findAll();
	}
	
	
	@GetMapping("/shops/{id}")
	public Shop getShopById(@PathVariable Long id){
		Shop shop = null;

		Optional<Shop> optShop = shopJpaRepository.findById(id);
		if (optShop.isPresent()) {
			shop = shopJpaRepository.findById(id).get();
		}

		return shop;
	}
	
	
	@DeleteMapping("/shops/{id}")
	public void deleteShopById(@PathVariable Long id) {
		this.shopJpaRepository.deleteById(id);
	}
	
	
	
	@PostMapping("/shops")
	public void createShop(@RequestBody Shop shop) {
		this.shopJpaRepository.save(shop);
	}
	
	@PutMapping("/shops/{id}")
	public void updateShopById(@PathVariable Long id, @RequestBody Shop newShop) {
		Shop oldShop = getShopById(id);
		if(oldShop.getId().equals(newShop.getId()))
			this.shopJpaRepository.save(newShop);
		
	}
	
	@PutMapping("/shops")
	public void updateShop(@RequestBody Shop shop) {
		this.shopJpaRepository.save(shop);
	}
	
	@GetMapping("/shops/{id}/groups")
	public boolean getGroupList(@PathVariable Long id) {
		//this.shopService.getOne(id).get
		//Collection<Group>
		
		return true;
	}	
	
	@GetMapping("/shops/{id}/products")
	public boolean getProductList(@PathVariable Long id) {
		// use the shop Repository
		// true return type is List<Product>
		
		return true;
	}
	
}