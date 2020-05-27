package com.webuy.WebuyAPI.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webuy.WebuyAPI.entities.User;

@RepositoryRestResource
public interface UserJPARepository extends JpaRepository<User, Long>{
	 @Query(" SELECT U FROM User U " +
	            "WHERE U.email = ?1 AND U.password = ?2")
	Optional<User> findUserByAuthentification(String email, String password);
}


