package com.webuy.WebuyAPI.services;

import java.util.Collection;

import com.webuy.WebuyAPI.entities.Shop;

public interface ShopService {
	public abstract Collection<Shop> getShops();
	public abstract Shop getOne(Long id);
	public abstract void createShop(Shop shop);
	public abstract void updateShop(Long id, Shop shop);
	public abstract void deleteShop(Long id);
}
