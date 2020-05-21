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

import com.webuy.WebuyAPI.dao.LocationJPARepository;
import com.webuy.WebuyAPI.entities.Location;

@RestController
public class LocationController {

	@Autowired
	private LocationJPARepository locationJpaRepository;

	@GetMapping("/locations")
	public Collection<Location> getAllLocations() {
		return this.locationJpaRepository.findAll();
	}

	@GetMapping("/locations/{id}")
	public Location getLocationById(@PathVariable Long id) {
		Location location = null;

		Optional<Location> locationOptional = locationJpaRepository.findById(id);
		if(locationOptional.isPresent()) {
			location = locationJpaRepository.findById(id).get();
		}

		return location;
	}

	@PostMapping("/locations")
	public void createLocation(@RequestBody Location location) {
		this.locationJpaRepository.save(location);
	}

	@PutMapping("/locations/{id}")
	public void updateLocation(@PathVariable Long id, @RequestBody Location newLocation) {
		Location oldLocation = getLocationById(id);
		if(oldLocation != null && oldLocation.getId().equals(newLocation.getId()))
			this.locationJpaRepository.save(newLocation);
	}

	@PutMapping("/locations")
	public void updateLocation(@RequestBody Location newLocation) {
		this.locationJpaRepository.save(newLocation);
	}

	@DeleteMapping("/locations/{id}")
	public void deleteLocation(@PathVariable Long id) {
		this.locationJpaRepository.deleteById(id);
	}

}
