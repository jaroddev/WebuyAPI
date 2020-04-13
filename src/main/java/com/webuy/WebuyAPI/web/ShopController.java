package com.webuy.WebuyAPI.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// import com.webuy.WebuyAPI.dao.ShopJPARepository;
// import com.webuy.WebuyAPI.entities.Shop;

@RestController
public class ShopController {
	
	// @Autowired
	// private ShopJPARepository shopRepo;

	
	public ShopController() {}
	
	/**
	 * shop or shops
	 * */
	@GetMapping("/shop")
	public boolean getShopList(){
		return true;
		// use the shop Repository
		// true return type is List<Group>
		// an example => return shopRepo.findAll(); of correct code
	}
	
	@GetMapping("/shop/{shopId}/groups")
	public boolean getGroupList(@PathVariable(value="shopID") Long id) {
		// use the shop Repository
		// true return type is List<Group>
		
		return true;
	}	
	
	@GetMapping("/shop/{shopId}/products")
	public boolean getProductList(@PathVariable(value="shopID") Long id) {
		// use the shop Repository
		// true return type is List<Product>
		
		return true;
	}
	
}


