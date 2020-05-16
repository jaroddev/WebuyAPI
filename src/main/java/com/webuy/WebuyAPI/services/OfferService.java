package com.webuy.WebuyAPI.services;

import java.util.Collection;

import com.webuy.WebuyAPI.entities.Offer;

public interface OfferService {
	public abstract Collection<Offer> getAll();
	public abstract Offer getOne(Long id);
	public abstract void createOffer(Offer offer);
	public abstract void updateOffer(Long id, Offer offer);
	public abstract void deleteOffer(Long id);
}
