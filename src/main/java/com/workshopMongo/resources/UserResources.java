package com.workshopMongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workshopMongo.domain.User;
import com.workshopMongo.dto.UserDTO;
import com.workshopMongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@Autowired
	private UserService serviceUser;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = serviceUser.findAll();
		List<UserDTO> listDTO = list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findbyId(@PathVariable String id) {
		
		User userById = serviceUser.findById(id);

		return ResponseEntity.ok().body(new UserDTO(userById));
	}
}
