package com.webuy.WebuyAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webuy.WebuyAPI.entities.Invitation;

@RepositoryRestResource
public interface InvitationJPARepository extends JpaRepository<Invitation, Long>{}


