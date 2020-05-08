package com.webuy.WebuyAPI.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.webuy.WebuyAPI.entities.Shop;
import com.webuy.WebuyAPI.services.ShopServiceImpl;

@RestController
public class ShopController {
	
	@Autowired
	private ShopServiceImpl shopService;

	public ShopController() {}
	
	@GetMapping("/shop")
	public Collection<Shop> getShopList(){
		return this.shopService.getShops();
	}
	
	@GetMapping("/shop/{shopId}/groups")
	public boolean getGroupList(@PathVariable Long id) {
		//this.shopService.getOne(id).get
		
		return true;
	}	
	
	@GetMapping("/shop/{shopId}/products")
	public boolean getProductList(@PathVariable Long id) {
		// use the shop Repository
		// true return type is List<Product>
		
		return true;
	}
	
}


