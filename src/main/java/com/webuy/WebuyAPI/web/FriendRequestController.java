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

import com.webuy.WebuyAPI.dao.FriendRequestJPARepository;
import com.webuy.WebuyAPI.entities.FriendRequest;

public class FriendRequestController {

	@Autowired
	private FriendRequestJPARepository friendRequestJpaRepository;

	@GetMapping("/friendRequests")
	public Collection<FriendRequest> getAllFriendRequests(){
		return this.friendRequestJpaRepository.findAll();
	}
	
	@GetMapping("friendRequests/{id}")
	public FriendRequest getFriendRequestById(Long id)
	{
		FriendRequest friendRequest = null;

		Optional<FriendRequest> friendRequestOptional = friendRequestJpaRepository.findById(id);
		if (friendRequestOptional.isPresent()) {
			friendRequest = friendRequestJpaRepository.findById(id).get();
		}

		return friendRequest;
	}
	
	@PostMapping("/friendRequests")
	public void createFriendRequest(@RequestBody FriendRequest friendRequest) {
		this.friendRequestJpaRepository.save(friendRequest);
	}
	
	@PutMapping("/friendRequests/{id}")
	public void updateFriendRequest(@PathVariable Long id, @RequestBody FriendRequest newFriendRequest) 
	{
		FriendRequest oldFriendRequest = getFriendRequestById(id);
		if(oldFriendRequest.getId().equals(newFriendRequest.getId()))
				this.friendRequestJpaRepository.save(newFriendRequest);
	}
	
	@PutMapping("/friendRequests")
	public void updateFriendRequest(@RequestBody FriendRequest newFriendRequest) 
	{
			this.friendRequestJpaRepository.save(newFriendRequest);
	}
	
	@DeleteMapping("/friendRequests/{id}")
	public void deleteShop(@PathVariable Long id) {
		this.friendRequestJpaRepository.deleteById(id);
	}
}
