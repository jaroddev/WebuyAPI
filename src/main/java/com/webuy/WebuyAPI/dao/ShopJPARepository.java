package com.webuy.WebuyAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webuy.WebuyAPI.entities.Shop;

@RepositoryRestResource
public interface ShopJPARepository extends JpaRepository<Shop, Long>{
	
}


