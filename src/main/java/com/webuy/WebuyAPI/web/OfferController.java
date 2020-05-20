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

import com.webuy.WebuyAPI.dao.OfferJPARepository;
import com.webuy.WebuyAPI.entities.Offer;

@RestController
public class OfferController {

	@Autowired
	private OfferJPARepository offerJpaRepository;

	@GetMapping("/offers")
	public Collection<Offer> getAllOffers(){
		return this.offerJpaRepository.findAll();
	}
	
	@GetMapping("offers/{id}")
	public Offer getOfferById(Long id)
	{
		Offer offer = null;

		Optional<Offer> offerOptional = offerJpaRepository.findById(id);
		if (offerOptional.isPresent()) {
			offer = offerJpaRepository.findById(id).get();
		}

		return offer;
	}
	
	@PostMapping("/offers")
	public void createOffer(@RequestBody Offer offer) {
		this.offerJpaRepository.save(offer);
	}
	
	@PutMapping("/offers/{id}")
	public void updateOffer(@PathVariable Long id, @RequestBody Offer newOffer) 
	{
		Offer oldOffer = getOfferById(id);
		if(oldOffer.getId().equals(newOffer.getId()))
				this.offerJpaRepository.save(newOffer);
	}
	
	@PutMapping("/offers")
	public void updateOffer(@RequestBody Offer newOffer) 
	{
			this.offerJpaRepository.save(newOffer);
	}
	
	@DeleteMapping("/offers/{id}")
	public void deleteShop(@PathVariable Long id) {
		this.offerJpaRepository.deleteById(id);
	}
}
