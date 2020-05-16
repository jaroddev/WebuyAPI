package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "groups")
public class Group implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private User leader;
	
	@ManyToMany
	private Collection<User> members;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	private Collection<Chat> chats;
	
	@OneToOne
	private Offer offer;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Collection<Chat> getChats() {
		return chats;
	}

	public void setChat(Collection<Chat> chats) {
		this.chats = chats;
	}
	
	public void addChat(Chat chat) {
		chats.add(chat);
	}

	public void removeChat(Long chatId) {
		this.chats.removeIf( chat -> chat.getId().equals(chatId));
	}
	
	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}
