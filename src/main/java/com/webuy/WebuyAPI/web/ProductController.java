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

import com.webuy.WebuyAPI.dao.ProductJPARepository;
import com.webuy.WebuyAPI.dao.ShopJPARepository;
import com.webuy.WebuyAPI.dto.ProductDTO;
import com.webuy.WebuyAPI.entities.Product;
import com.webuy.WebuyAPI.entities.Shop;

@RestController
public class ProductController {

	@Autowired
	private ProductJPARepository productJpaRepository;

	@Autowired
	private ShopJPARepository shopJpaRepository;

	@GetMapping("/products")
	public Collection<Product> getAllProducts() {
		return this.productJpaRepository.findAll();
	}

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable Long id) {
		Product product = null;

		Optional<Product> productOptional = productJpaRepository.findById(id);
		if (productOptional.isPresent()) {
			product = productJpaRepository.findById(id).get();
		}

		return product;
	}

	@PostMapping("/products")
	public void createProduct(@RequestBody Product product) {
		this.productJpaRepository.save(product);
	}

	@PutMapping("/products/{id}")
	public void updateProduct(@PathVariable Long id, @RequestBody Product newProduct) {
		Product oldProduct = getProductById(id);
		if (oldProduct.getId().equals(newProduct.getId()))
			this.productJpaRepository.save(newProduct);
	}

	@PutMapping("/products")
	public void updateProduct(@RequestBody Product newProduct) {
		this.productJpaRepository.save(newProduct);
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		this.productJpaRepository.deleteById(id);
	}

	@PostMapping("/products/of-shop")
	public void createProductOfShop(@RequestBody ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setStock(productDTO.getStock());
		product.setImages(productDTO.getImages());

		product = productJpaRepository.save(product);

		Optional<Shop> optShop = shopJpaRepository.findById(productDTO.getShopId());

		if (optShop.isPresent()) {
			Shop shop = optShop.get();

			shop.getProducts().add(product);

			shopJpaRepository.save(shop);
		}
	}

	@PutMapping("/products/of-shop/{id}")
	public void updateProductOfShop(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
		Optional<Product> optProduct = productJpaRepository.findById(id);

		if (!optProduct.isPresent()) {
			return;
		}

		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setStock(productDTO.getStock());
		product.setImages(productDTO.getImages());

		product = productJpaRepository.save(product);

		Optional<Shop> optShop = shopJpaRepository.findById(productDTO.getShopId());

		if (optShop.isPresent()) {
			Shop shop = optShop.get();

			shop.getProducts().add(product);

			shopJpaRepository.save(shop);
		}
	}

}
