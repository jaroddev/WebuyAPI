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

import com.webuy.WebuyAPI.dao.ImagesPointerJPARepository;
import com.webuy.WebuyAPI.entities.ImagesPointer;

@RestController
public class ImagesPointerController {

	@Autowired
	private ImagesPointerJPARepository imagesPointerJpaRepository;

	@GetMapping("/images-pointers")
	public Collection<ImagesPointer> getAllImagesPointers() {
		return this.imagesPointerJpaRepository.findAll();
	}

	@GetMapping("/images-pointers/{id}")
	public ImagesPointer getImagesPointerById(@PathVariable Long id) {
		ImagesPointer imagesPointer = null;

		Optional<ImagesPointer> imagesPointerOptional = imagesPointerJpaRepository.findById(id);
		if(imagesPointerOptional.isPresent()) {
			imagesPointer = imagesPointerJpaRepository.findById(id).get();
		}

		return imagesPointer;
	}

	@PostMapping("/images-pointers")
	public void createImagesPointer(@RequestBody ImagesPointer imagesPointer) {
		this.imagesPointerJpaRepository.save(imagesPointer);
	}

	@PutMapping("/images-pointers/{id}")
	public void updateImagesPointer(@PathVariable Long id, @RequestBody ImagesPointer newImagesPointer) {
		ImagesPointer oldImagesPointer = getImagesPointerById(id);
		if(oldImagesPointer != null && oldImagesPointer.getId().equals(newImagesPointer.getId()))
			this.imagesPointerJpaRepository.save(newImagesPointer);
	}

	@PutMapping("/images-pointers")
	public void updateImagesPointer(@RequestBody ImagesPointer newImagesPointer) {
		this.imagesPointerJpaRepository.save(newImagesPointer);
	}

	@DeleteMapping("/images-pointers/{id}")
	public void deleteImagesPointer(@PathVariable Long id) {
		this.imagesPointerJpaRepository.deleteById(id);
	}

}
