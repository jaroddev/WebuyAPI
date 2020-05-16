package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getAlternativeTextLogo() {
		return alternativeTextLogo;
	}
	public void setAlternativeTextLogo(String alternativeTextLogo) {
		this.alternativeTextLogo = alternativeTextLogo;
	}
	private String urlImage;
	private String alternativeTextLogo;

}
