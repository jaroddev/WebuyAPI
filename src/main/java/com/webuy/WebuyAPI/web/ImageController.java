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

import com.webuy.WebuyAPI.dao.ImageJPARepository;
import com.webuy.WebuyAPI.entities.Image;

@RestController
public class ImageController {

	@Autowired
	private ImageJPARepository imageJpaRepository;

	@GetMapping("/images")
	public Collection<Image> getAllImages() {
		return this.imageJpaRepository.findAll();
	}

	@GetMapping("/images/{id}")
	public Image getImageById(@PathVariable Long id) {
		Image image = null;

		Optional<Image> imageOptional = imageJpaRepository.findById(id);
		if(imageOptional.isPresent()) {
			image = imageJpaRepository.findById(id).get();
		}

		return image;
	}

	@PostMapping("/images")
	public void createImage(@RequestBody Image image) {
		this.imageJpaRepository.save(image);
	}

	@PutMapping("/images/{id}")
	public void updateImage(@PathVariable Long id, @RequestBody Image newImage) {
		Image oldImage = getImageById(id);
		if(oldImage != null && oldImage.getId().equals(newImage.getId()))
			this.imageJpaRepository.save(newImage);
	}

	@PutMapping("/images")
	public void updateImage(@RequestBody Image newImage) {
		this.imageJpaRepository.save(newImage);
	}

	@DeleteMapping("/images/{id}")
	public void deleteImage(@PathVariable Long id) {
		this.imageJpaRepository.deleteById(id);
	}

}
