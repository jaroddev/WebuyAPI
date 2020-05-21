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

import com.webuy.WebuyAPI.dao.AddressJPARepository;
import com.webuy.WebuyAPI.entities.Address;

@RestController
public class AddressController {

	@Autowired
	private AddressJPARepository addressJpaRepository;

	@GetMapping("/addresses")
	public Collection<Address> getAllAddresses() {
		return this.addressJpaRepository.findAll();
	}

	@GetMapping("/addresses/{id}")
	public Address getAddressById(@PathVariable Long id) {
		Address address = null;

		Optional<Address> addressOptional = addressJpaRepository.findById(id);
		if(addressOptional.isPresent()) {
			address = addressJpaRepository.findById(id).get();
		}

		return address;
	}

	@PostMapping("/addresses")
	public void createAddress(@RequestBody Address address) {
		this.addressJpaRepository.save(address);
	}

	@PutMapping("/addresses/{id}")
	public void updateAddress(@PathVariable Long id, @RequestBody Address newAddress) {
		Address oldAddress = getAddressById(id);
		if(oldAddress != null && oldAddress.getId().equals(newAddress.getId()))
			this.addressJpaRepository.save(newAddress);
	}

	@PutMapping("/addresses")
	public void updateAddress(@RequestBody Address newAddress) {
		this.addressJpaRepository.save(newAddress);
	}

	@DeleteMapping("/addresses/{id}")
	public void deleteAddress(@PathVariable Long id) {
		this.addressJpaRepository.deleteById(id);
	}

}
