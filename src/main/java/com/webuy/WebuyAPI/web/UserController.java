package com.webuy.WebuyAPI.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webuy.WebuyAPI.entities.User;
import com.webuy.WebuyAPI.services.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/product/{id}")
	public void getUser(@PathVariable Long id) {
		this.userService.getOne(id);
	}
	
	@PostMapping("/product")
	public void addShop(@RequestBody User product) {
		this.userService.createUser(product);
	}
	
	@PutMapping("/product/{id}")
	public void editShop(@PathVariable Long id, @RequestBody User product) {
		this.userService.updateUser(id, product);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteShop(@PathVariable Long id) {
		this.userService.deleteUser(id);
	}	
	
}
