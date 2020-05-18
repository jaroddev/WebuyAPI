package com.webuy.WebuyAPI.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

@Entity
public class GPSLocationPointer implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private Location location;

	public Long getId() {
		return id;
	}

	/*public void setId(Long id) {
	this.id = id;
}*/

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
