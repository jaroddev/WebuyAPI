package com.webuy.WebuyAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webuy.WebuyAPI.entities.Product;

@RepositoryRestResource
public interface ProductJPARepository extends JpaRepository<Product, Long>{
	@Modifying
	@Query("delete from Product p where p.id = ?1")
	void delete(Long productId);
}


