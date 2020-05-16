package com.webuy.WebuyAPI.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.webuy.WebuyAPI.dao.UserJPARepository;
import com.webuy.WebuyAPI.entities.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserJPARepository repo;
	
	@Override
	public User getOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void createUser(User user) {
		repo.save(user);
	}

	@Override
	public void updateUser(Long id, User user) {
		
	}

	@Override
	public void deleteUser(Long id) {
		repo.findById(id).ifPresent(user -> repo.deleteById(id));
	}

}
