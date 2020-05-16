package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShopGroup implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String urlLogo;
	private String alternativeTextLogo;
	
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
	public String getUrlLogo() {
		return urlLogo;
	}
	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	public String getAlternativeTextLogo() {
		return alternativeTextLogo;
	}
	public void setAlternativeTextLogo(String alternativeTextLogo) {
		this.alternativeTextLogo = alternativeTextLogo;
	}
}
