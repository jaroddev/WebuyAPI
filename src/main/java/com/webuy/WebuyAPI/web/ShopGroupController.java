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

import com.webuy.WebuyAPI.dao.ShopGroupJPARepository;
import com.webuy.WebuyAPI.entities.ShopGroup;

public class ShopGroupController {

	@Autowired
	private ShopGroupJPARepository shopGroupJpaRepository;

	@GetMapping("/shopGroups")
	public Collection<ShopGroup> getAllShopGroups(){
		return this.shopGroupJpaRepository.findAll();
	}
	
	@GetMapping("shopGroups/{id}")
	public ShopGroup getShopGroupById(Long id)
	{
		ShopGroup shopGroup = null;

		Optional<ShopGroup> shopGroupOptional = shopGroupJpaRepository.findById(id);
		if (shopGroupOptional.isPresent()) {
			shopGroup = shopGroupJpaRepository.findById(id).get();
		}

		return shopGroup;
	}
	
	@PostMapping("/shopGroups")
	public void createShopGroup(@RequestBody ShopGroup shopGroup) {
		this.shopGroupJpaRepository.save(shopGroup);
	}
	
	@PutMapping("/shopGroups/{id}")
	public void updateShopGroup(@PathVariable Long id, @RequestBody ShopGroup newShopGroup) 
	{
		ShopGroup oldShopGroup = getShopGroupById(id);
		if(oldShopGroup.getId().equals(newShopGroup.getId()))
				this.shopGroupJpaRepository.save(newShopGroup);
	}
	
	@PutMapping("/shopGroups")
	public void updateShopGroup(@RequestBody ShopGroup newShopGroup) 
	{
			this.shopGroupJpaRepository.save(newShopGroup);
	}
	
	@DeleteMapping("/shopGroups/{id}")
	public void deleteShop(@PathVariable Long id) {
		this.shopGroupJpaRepository.deleteById(id);
	}
}
