package com.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopMongo.domain.User;
import com.workshopMongo.repositories.UserRepository;
import com.workshopMongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
