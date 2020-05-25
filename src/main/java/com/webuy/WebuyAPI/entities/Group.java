package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "groups")
public class Group implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnoreProperties({ "friends", "sentFriendRequests", "receivedFriendRequests", "groups", "groupsCreate",
			"sentGroupInvitations", "receivedGroupInvitations" })
	@ManyToOne
	private User leader;

	@JsonIgnoreProperties({ "friends", "sentFriendRequests", "receivedFriendRequests", "groups", "groupsCreate",
			"sentGroupInvitations", "receivedGroupInvitations" })
	@ManyToMany
	private Collection<User> members;

	@OneToMany(cascade = CascadeType.REMOVE)
	private Collection<Message> messages;

	@ManyToOne
	private Offer offer;

	public Long getId() {
		return id;
	}

	/*
	 * public void setId(Long id) { this.id = id; }
	 */

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public Collection<User> getMembers() {
		return members;
	}

	public void setMembers(Collection<User> members) {
		this.members = members;
	}

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setChat(Collection<Message> messages) {
		this.messages = messages;
	}

	public void addChat(Message message) {
		messages.add(message);
	}

	public void removeChat(Long messageId) {
		this.messages.removeIf(chat -> chat.getId().equals(messageId));
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}
