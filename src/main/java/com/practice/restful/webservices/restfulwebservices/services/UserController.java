package com.practice.restful.webservices.restfulwebservices.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path="/getAllUsers")
	public List<User>retriveAll() {
		
		return service.findAll();
		
	}
	
	@GetMapping(path="/getUserById/{id}")
	public User getUserById(@PathVariable int id) {
		
		return service.findOne(id);
		
	}
	
	@PostMapping(path="/save")
	public ResponseEntity<Object> save(@RequestBody User user) {
		
		User savedUser = service.save(user);	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
