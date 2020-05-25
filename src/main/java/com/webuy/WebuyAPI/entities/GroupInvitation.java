package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class GroupInvitation implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnoreProperties({ "friends", "sentFriendRequests", "receivedFriendRequests", "groups", "groupsCreate",
			"sentGroupInvitations", "receivedGroupInvitations" })
	@ManyToOne
	private User sender;
	@JsonIgnoreProperties({ "friends", "sentFriendRequests", "receivedFriendRequests", "groups", "groupsCreate",
			"sentGroupInvitations", "receivedGroupInvitations" })
	@ManyToOne
	private User receiver;
	@JsonIgnoreProperties({ "leader", "members", "messages" })
	@ManyToOne
	private Group group;

	public Long getId() {
		return id;
	}

	/*
	 * public void setId(Long id) { this.id = id; }
	 */

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
