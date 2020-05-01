package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;

@Entity
public class Group implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private int validity;
	
	@OneToOne
	private User leader;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "memberId")
	private Collection<User> members;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "messageId")
	private Collection<GroupMessage> messages;
	
	@OneToOne
	private Offer offer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

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

	public Collection<GroupMessage> getMessages() {
		return messages;
	}

	public void setMessages(Collection<GroupMessage> messages) {
		this.messages = messages;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}
