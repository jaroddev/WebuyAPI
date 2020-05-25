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

import com.webuy.WebuyAPI.dao.FriendRequestJPARepository;
import com.webuy.WebuyAPI.entities.FriendRequest;

@RestController
public class FriendRequestController {

	@Autowired
	private FriendRequestJPARepository friendRequestJpaRepository;

	@GetMapping("/friend-requests")
	public Collection<FriendRequest> getAllFriendRequests() {
		return this.friendRequestJpaRepository.findAll();
	}

	@GetMapping("/friend-requests/{id}")
	public FriendRequest getFriendRequestById(@PathVariable Long id) {
		FriendRequest friendRequest = null;

		Optional<FriendRequest> friendRequestOptional = friendRequestJpaRepository.findById(id);
		if(friendRequestOptional.isPresent()) {
			friendRequest = friendRequestJpaRepository.findById(id).get();
		}

		return friendRequest;
	}

	@PostMapping("/friend-requests")
	public void createFriendRequest(@RequestBody FriendRequest friendRequest) {
		this.friendRequestJpaRepository.save(friendRequest);
	}

	@PutMapping("/friend-requests/{id}")
	public void updateFriendRequest(@PathVariable Long id, @RequestBody FriendRequest newFriendRequest) {
		FriendRequest oldFriendRequest = getFriendRequestById(id);
		if(oldFriendRequest != null && oldFriendRequest.getId().equals(newFriendRequest.getId()))
			this.friendRequestJpaRepository.save(newFriendRequest);
	}

	@PutMapping("/friend-requests")
	public void updateFriendRequest(@RequestBody FriendRequest newFriendRequest) {
		this.friendRequestJpaRepository.save(newFriendRequest);
	}

	@DeleteMapping("/friend-requests/{id}")
	public void deleteFriendRequest(@PathVariable Long id) {
		this.friendRequestJpaRepository.deleteById(id);
	}

}
