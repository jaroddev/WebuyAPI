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

import com.webuy.WebuyAPI.dao.GroupInvitationJPARepository;
import com.webuy.WebuyAPI.entities.GroupInvitation;

public class GroupInvitationController {

	@Autowired
	private GroupInvitationJPARepository groupInvitationJpaRepository;

	@GetMapping("/groupInvitations")
	public Collection<GroupInvitation> getAllGroupInvitations(){
		return this.groupInvitationJpaRepository.findAll();
	}
	
	@GetMapping("groupInvitations/{id}")
	public GroupInvitation getGroupInvitationById(Long id)
	{
		GroupInvitation groupInvitation = null;

		Optional<GroupInvitation> groupInvitationOptional = groupInvitationJpaRepository.findById(id);
		if (groupInvitationOptional.isPresent()) {
			groupInvitation = groupInvitationJpaRepository.findById(id).get();
		}

		return groupInvitation;
	}
	
	@PostMapping("/groupInvitations")
	public void createGroupInvitation(@RequestBody GroupInvitation groupInvitation) {
		this.groupInvitationJpaRepository.save(groupInvitation);
	}
	
	@PutMapping("/groupInvitations/{id}")
	public void updateGroupInvitation(@PathVariable Long id, @RequestBody GroupInvitation newGroupInvitation) 
	{
		GroupInvitation oldGroupInvitation = getGroupInvitationById(id);
		if(oldGroupInvitation.getId().equals(newGroupInvitation.getId()))
				this.groupInvitationJpaRepository.save(newGroupInvitation);
	}
	
	@PutMapping("/groupInvitations")
	public void updateGroupInvitation(@RequestBody GroupInvitation newGroupInvitation) 
	{
			this.groupInvitationJpaRepository.save(newGroupInvitation);
	}
	
	@DeleteMapping("/groupInvitations/{id}")
	public void deleteShop(@PathVariable Long id) {
		this.groupInvitationJpaRepository.deleteById(id);
	}
}
