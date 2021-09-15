package com.workshopMongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workshopMongo.domain.User;
import com.workshopMongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@Autowired
	private UserService serviceUser;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {

		List<User> list = serviceUser.findAll();
		return ResponseEntity.ok().body(list);
	}
}
