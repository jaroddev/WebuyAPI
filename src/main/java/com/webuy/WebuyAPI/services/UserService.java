package com.webuy.WebuyAPI.services;

import com.webuy.WebuyAPI.entities.User;

public interface UserService {
	public abstract User getOne(Long id);
	public abstract void createUser(User user);
	public abstract void updateUser(Long id, User user);
	public abstract void deleteUser(Long id);
}
