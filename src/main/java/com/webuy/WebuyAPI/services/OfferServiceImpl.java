package com.webuy.WebuyAPI.services;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webuy.WebuyAPI.dao.OfferJPARepository;
import com.webuy.WebuyAPI.entities.Offer;
import com.webuy.WebuyAPI.entities.Shop;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	OfferJPARepository repo;

	@Override
	public Collection<Offer> getAll() {
		return repo.findAll();
	}

	@Override
	public Offer getOne(Long id) {
		Offer offer = null;

		Optional<Offer> optShop = repo.findById(id);
		if (optShop.isPresent()) {
			offer = repo.findById(id).get();
		}

		return offer;
	}

	@Override
	public void createOffer(Offer offer) {
		repo.save(offer);
	}

	@Override
	public void updateOffer(Long id, Offer newOffer) {
		repo.findById(id).ifPresent(offer -> {
			offer.setDiscountPrice(newOffer.getDiscountPrice());
			offer.setEnd(newOffer.getEnd());
			offer.setMaxMemberCount(newOffer.getMaxMemberCount());
			offer.setMinMemberCount(newOffer.getMinMemberCount());
			offer.setStart(newOffer.getStart());
			offer.setStock(newOffer.getStock());

			repo.save(offer);
		});
	}

	@Override
	public void deleteOffer(Long id) {
		repo.findById(id).ifPresent(offer -> repo.deleteById(id));
	}

}
