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

import com.webuy.WebuyAPI.dao.UserJPARepository;
import com.webuy.WebuyAPI.entities.User;

@RestController
public class UserController {

	@Autowired
	private UserJPARepository userJpaRepository;

	@GetMapping("/users")
	public Collection<User> getAllUsers() {
		return this.userJpaRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable Long id) {
		User user = null;

		Optional<User> userOptional = userJpaRepository.findById(id);
		if (userOptional.isPresent()) {
			user = userJpaRepository.findById(id).get();
		}

		return user;
	}

	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		this.userJpaRepository.save(user);
	}

	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable Long id, @RequestBody User newUser) {
		User oldUser = getUserById(id);
		if (oldUser.getId().equals(newUser.getId()))
			this.userJpaRepository.save(newUser);
	}

	@PutMapping("/users")
	public void updateUser(@RequestBody User newUser) {
		this.userJpaRepository.save(newUser);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		this.userJpaRepository.deleteById(id);
	}

}
