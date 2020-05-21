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

import com.webuy.WebuyAPI.dao.GPSLocationPointerJPARepository;
import com.webuy.WebuyAPI.entities.GPSLocationPointer;

@RestController
public class GPSLocationPointerController {

	@Autowired
	private GPSLocationPointerJPARepository gpsLocationPointerJpaRepository;

	@GetMapping("/gps-location-pointers")
	public Collection<GPSLocationPointer> getAllGPSLocationPointers() {
		return this.gpsLocationPointerJpaRepository.findAll();
	}

	@GetMapping("/gps-location-pointers/{id}")
	public GPSLocationPointer getGPSLocationPointerById(@PathVariable Long id) {
		GPSLocationPointer gpsLocationPointer = null;

		Optional<GPSLocationPointer> gpsLocationPointerOptional = gpsLocationPointerJpaRepository.findById(id);
		if(gpsLocationPointerOptional.isPresent()) {
			gpsLocationPointer = gpsLocationPointerJpaRepository.findById(id).get();
		}

		return gpsLocationPointer;
	}

	@PostMapping("/gps-location-pointers")
	public void createGPSLocationPointer(@RequestBody GPSLocationPointer gpsLocationPointer) {
		this.gpsLocationPointerJpaRepository.save(gpsLocationPointer);
	}

	@PutMapping("/gps-location-pointers/{id}")
	public void updateGPSLocationPointer(@PathVariable Long id, @RequestBody GPSLocationPointer newGPSLocationPointer) {
		GPSLocationPointer oldGPSLocationPointer = getGPSLocationPointerById(id);
		if(oldGPSLocationPointer != null && oldGPSLocationPointer.getId().equals(newGPSLocationPointer.getId()))
			this.gpsLocationPointerJpaRepository.save(newGPSLocationPointer);
	}

	@PutMapping("/gps-location-pointers")
	public void updateGPSLocationPointer(@RequestBody GPSLocationPointer newGPSLocationPointer) {
		this.gpsLocationPointerJpaRepository.save(newGPSLocationPointer);
	}

	@DeleteMapping("/gps-location-pointers/{id}")
	public void deleteGPSLocationPointer(@PathVariable Long id) {
		this.gpsLocationPointerJpaRepository.deleteById(id);
	}

}
