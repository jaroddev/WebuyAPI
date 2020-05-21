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

import com.webuy.WebuyAPI.dao.MessageJPARepository;
import com.webuy.WebuyAPI.entities.Message;

@RestController
public class MessageController {

	@Autowired
	private MessageJPARepository messageJpaRepository;

	@GetMapping("/messages")
	public Collection<Message> getAllMessages() {
		return this.messageJpaRepository.findAll();
	}

	@GetMapping("/messages/{id}")
	public Message getMessageById(@PathVariable Long id) {
		Message message = null;

		Optional<Message> messageOptional = messageJpaRepository.findById(id);
		if(messageOptional.isPresent()) {
			message = messageJpaRepository.findById(id).get();
		}

		return message;
	}

	@PostMapping("/messages")
	public void createMessage(@RequestBody Message message) {
		this.messageJpaRepository.save(message);
	}

	@PutMapping("/messages/{id}")
	public void updateMessage(@PathVariable Long id, @RequestBody Message newMessage) {
		Message oldMessage = getMessageById(id);
		if(oldMessage != null && oldMessage.getId().equals(newMessage.getId()))
			this.messageJpaRepository.save(newMessage);
	}

	@PutMapping("/messages")
	public void updateMessage(@RequestBody Message newMessage) {
		this.messageJpaRepository.save(newMessage);
	}

	@DeleteMapping("/messages/{id}")
	public void deleteMessage(@PathVariable Long id) {
		this.messageJpaRepository.deleteById(id);
	}

}
