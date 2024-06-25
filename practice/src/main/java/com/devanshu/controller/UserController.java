package com.devanshu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.devanshu.entity.User;
import com.devanshu.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User createUser = userService.createUser(user);
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}
		
	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userService.getSingleUser(id);
	}
	
	@GetMapping("/")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@GetMapping("/name/{n}")
	public User getUserByName(@PathVariable("n") String name) {
		return userService.getUserByName(name);
	}

}
