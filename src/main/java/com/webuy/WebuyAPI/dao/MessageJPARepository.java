package com.webuy.WebuyAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webuy.WebuyAPI.entities.Message;

@RepositoryRestResource
public interface MessageJPARepository extends JpaRepository<Message, Long>{}


