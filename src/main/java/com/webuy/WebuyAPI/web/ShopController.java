package com.webuy.WebuyAPI.web;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webuy.WebuyAPI.dao.OfferJPARepository;
import com.webuy.WebuyAPI.dao.ProductJPARepository;
import com.webuy.WebuyAPI.dao.ShopJPARepository;
import com.webuy.WebuyAPI.dto.ShopDTO;
import com.webuy.WebuyAPI.entities.Product;
import com.webuy.WebuyAPI.entities.Shop;

@RestController
public class ShopController {

	@Autowired
	ShopJPARepository shopJpaRepository;

	@Autowired
	ProductJPARepository productJpaRepository;

	@Autowired
	OfferJPARepository offerJpaRepository;

	@GetMapping("/shops")
	public Collection<Shop> getAllShops() {
		return this.shopJpaRepository.findAll();
	}

	@GetMapping("/shops/{id}")
	public Shop getShopById(@PathVariable Long id) {
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
		if (oldShop.getId().equals(newShop.getId()))
			this.shopJpaRepository.save(newShop);

	}

	@PutMapping("/shops")
	public void updateShop(@RequestBody Shop shop) {
		this.shopJpaRepository.save(shop);
	}

	@GetMapping("/shops/{id}/groups")
	public boolean getGroupList(@PathVariable Long id) {
		// this.shopService.getOne(id).get
		// Collection<Group>

		return true;
	}

	@GetMapping("/shops/{id}/products")
	public boolean getProductList(@PathVariable Long id) {
		// use the shop Repository
		// true return type is List<Product>

		return true;
	}

	@PutMapping("/shops/{id}/product")
	@Transactional
	public void updateShopProducts(@PathVariable Long id, @RequestBody ShopDTO shopDTO) {
		Optional<Shop> optShop = shopJpaRepository.findById(id);

		if (!optShop.isPresent()) {
			return;
		}

		Shop shop = optShop.get();
		shop.setId(shopDTO.getId());
		shop.setAddress(shopDTO.getAddress());
		shop.setImages(shopDTO.getImages());
		shop.setShopGroup(shopDTO.getShopGroup());

		shopDTO.getRemovedProducts().stream().forEach(prodId -> {
			Optional<Product> optProduct = productJpaRepository.findById(prodId);

			if (optProduct.isPresent()) {
				Product product = optProduct.get();

				System.out.println(product.getName());

				// shop.getProducts().remove(product);

				productJpaRepository.delete(prodId);
				offerJpaRepository.deleteProductOffers(prodId);
			}
		});

		shopJpaRepository.save(shop);
	}

	@GetMapping("/shops/having-product/{id}")
	public Shop getShopHavingProduct(@PathVariable Long id) {
		for (Shop shop : shopJpaRepository.findAll()) {
			for (Product product : shop.getProducts()) {
				if (product.getId().equals(id)) {
					return shop;
				}
			}
		}

		return null;
	}

}
