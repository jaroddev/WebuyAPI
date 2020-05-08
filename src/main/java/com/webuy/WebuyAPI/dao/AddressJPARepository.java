package com.webuy.WebuyAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webuy.WebuyAPI.entities.Address;

@RepositoryRestResource
public interface AddressJPARepository extends JpaRepository<Address, Long>{}


