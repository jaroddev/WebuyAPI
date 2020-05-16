package com.webuy.WebuyAPI.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class ImagesPointer implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pointer_id")
	private List<Image> images= new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	public void addImage(Image image) {
		this.images.add(image);
	}
	
	public void removeProduct(Long imageId) {
    	for(Image image : this.images)
    		if(image.getId().equals(imageId)) this.images.remove(image);
    }

}
