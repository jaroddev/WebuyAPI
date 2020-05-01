package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;

@Entity
public class GroupMessage implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public User getSender() {
		return sender;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getContent() {
		return content;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@OneToOne
	private User sender;
	
	private Date createdAt;
	
	@Lob 
	@Column(name="content", length=512)
	private String content;
	
}
