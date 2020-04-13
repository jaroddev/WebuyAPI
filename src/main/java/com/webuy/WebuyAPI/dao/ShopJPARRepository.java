package com.webuy.WebuyAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShopJPARRepository extends JpaRepository<String, Long>{ // Here should be Shop

}


