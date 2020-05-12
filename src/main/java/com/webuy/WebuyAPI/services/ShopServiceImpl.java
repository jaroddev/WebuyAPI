package com.webuy.WebuyAPI.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webuy.WebuyAPI.dao.AddressJPARepository;
import com.webuy.WebuyAPI.dao.ShopJPARepository;
import com.webuy.WebuyAPI.entities.Shop;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	ShopJPARepository repo;
	
	@Autowired
	AddressJPARepository addressRepo;
	
	@Override
	public Collection<Shop> getAll() {
		return repo.findAll();
	}
	
	@Override
	public Shop getOne(Long id) {
		Shop shop;

		Optional<Shop> optShop= repo.findById(id);
		if (optShop.isPresent()) {
			shop = repo.findById(id).get();
		}else {
			shop = new Shop();
		}		
		return shop;
	}
	
	@Override
	public void createShop(Shop newShop) {
		repo.save(newShop);
	}

	@Override
	public void updateShop(Long id, Shop newShop) {
		if(repo.existsById(id)) {
			repo.findById(id).ifPresent( shop -> {
				shop.setAddress(newShop.getAddress());
				shop.setName(newShop.getName());
				shop.setImage(newShop.getImage());
				repo.save(shop);
			});
		}
	}

	@Override
	public void deleteShop(Long id) {
		repo.findById(id).ifPresent(shop -> {
			repo.deleteById(id);
		});		
	}
}
