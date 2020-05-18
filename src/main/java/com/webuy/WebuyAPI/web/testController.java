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
public class testController {

	@Autowired
	ShopJPARepository shopJpaRepository;
	
	@GetMapping("/testShops")
	public Collection<Shop> findAllShop(){
		return this.shopJpaRepository.findAll();
	}
	
	
	@GetMapping("/testShops/{id}")
	public Shop findShopById(@PathVariable Long id){
		Shop shop = null;

		Optional<Shop> optShop = shopJpaRepository.findById(id);
		if (optShop.isPresent()) {
			shop = shopJpaRepository.findById(id).get();
		}

		return shop;
	}
	
	
	@DeleteMapping("/testShops/{id}")
	public void deleteShopById(@PathVariable Long id) {
		this.shopJpaRepository.deleteById(id);
	}
	
	
	
	@PostMapping("/testShops")
	public void createShop(@RequestBody Shop shop) {
		this.shopJpaRepository.save(shop);
	}
	
	@PutMapping("/testShops/{id}")
	public void updateShopById(@PathVariable Long id, @RequestBody Shop newShop) {
		Shop oldShop = findShopById(id);
		this.shopJpaRepository.save(newShop);
		
	}
	
	@PutMapping("/testShops")
	public void updateShop(@RequestBody Shop shop) {
		this.shopJpaRepository.save(shop);
	}
	
	
}
