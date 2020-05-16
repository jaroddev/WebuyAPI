package com.webuy.WebuyAPI.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webuy.WebuyAPI.entities.Offer;
import com.webuy.WebuyAPI.services.OfferServiceImpl;

@RestController
public class OfferController {

	@Autowired
	private OfferServiceImpl offerService;

	@GetMapping("/offer")
	public Collection<Offer> getOfferList(){
		return this.offerService.getAll();
	}
	
	@GetMapping("/offer/{id}")
	public Offer getOffer(@PathVariable Long id){
		return this.offerService.getOne(id);
	}
	
	@PostMapping("/offer")
	public void addOffer(@RequestBody Offer offer) {
		this.offerService.createOffer(offer);
	}
	
	@PutMapping("/offer/{id}")
	public void editOffer(@PathVariable Long id, @RequestBody Offer offer) {
		this.offerService.updateOffer(id, offer);
	}
	
	@DeleteMapping("/offer/{id}")
	public void deleteOffer(@PathVariable Long id) {
		this.offerService.deleteOffer(id);
	}	
	
}
