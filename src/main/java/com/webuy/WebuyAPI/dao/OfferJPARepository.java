package com.webuy.WebuyAPI.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webuy.WebuyAPI.entities.Offer;

@RepositoryRestResource
public interface OfferJPARepository extends JpaRepository<Offer, Long> {
	public default void deleteProductOffers(Long productId) {
		Collection<Offer> allOffers = findAll();

		for (Offer offer : allOffers) {
			if (offer.getProduct() != null && offer.getProduct().getId().equals(productId)) {
				deleteById(offer.getId());
			}
		}
	}
}
