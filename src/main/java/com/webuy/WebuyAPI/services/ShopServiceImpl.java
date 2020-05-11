package com.webuy.WebuyAPI.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webuy.WebuyAPI.dao.AddressJPARepository;
import com.webuy.WebuyAPI.dao.ShopJPARepository;
import com.webuy.WebuyAPI.entities.Address;
import com.webuy.WebuyAPI.entities.Shop;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	ShopJPARepository repo;
	
	@Autowired
	AddressJPARepository addressRepo;
	
	@Override
	public Collection<Shop> getShops() {
		return repo.findAll();
	}
	
	@Override
	public Shop getOne(Long id) {
		return repo.getOne(id);
	}
	
	@Override
	public void createShop(Shop shop) {
		Address newAddress = addressRepo.saveAndFlush(shop.getAddress());
		shop.setAddress(newAddress);
		repo.saveAndFlush(shop);
	}

	@Override
	public void updateShop(Long id, Shop shop) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			Address newAddress = addressRepo.saveAndFlush(shop.getAddress());
			shop.setAddress(newAddress);
			shop.setId(id);
			repo.saveAndFlush(shop);
		}
	}

	@Override
	public void deleteShop(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}
	}
}
