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

import com.webuy.WebuyAPI.dao.GroupJPARepository;
import com.webuy.WebuyAPI.entities.Group;

@RestController
public class GroupController {

	@Autowired
	private GroupJPARepository groupJpaRepository;

	@GetMapping("/groups")
	public Collection<Group> getAllGroups() {
		return this.groupJpaRepository.findAll();
	}

	@GetMapping("/groups/{id}")
	public Group getGroupById(@PathVariable Long id) {
		Group group = null;

		Optional<Group> groupOptional = groupJpaRepository.findById(id);
		if(groupOptional.isPresent()) {
			group = groupJpaRepository.findById(id).get();
		}

		return group;
	}
	@PostMapping("/groups")
	public void createGroup(@RequestBody Group group) {
		this.groupJpaRepository.save(group);
	}

	@PutMapping("/groups/{id}")
	public void updateGroup(@PathVariable Long id, @RequestBody Group newGroup) {
		Group oldGroup = getGroupById(id);
		if(oldGroup != null && oldGroup.getId().equals(newGroup.getId()))
			this.groupJpaRepository.save(newGroup);
	}

	@PutMapping("/groups")
	public void updateGroup(@RequestBody Group newGroup) {
		this.groupJpaRepository.save(newGroup);
	}

	@DeleteMapping("/groups/{id}")
	public void deleteGroup(@PathVariable Long id) {
		this.groupJpaRepository.deleteById(id);
	}

}
