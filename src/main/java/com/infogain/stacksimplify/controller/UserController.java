package com.infogain.stacksimplify.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.infogain.stacksimplify.entities.User;
import com.infogain.stacksimplify.service.UserSerivceImpl;

//Controller
@RestController
public class UserController {

	// Autowired the services class

	@Autowired
	private UserSerivceImpl userSerivceImpl;

	@GetMapping("/users")
	public List<User> getAllUser() {
		return userSerivceImpl.getAllUsers();

	}// getAllUser

	
	// creatUser
	@PostMapping("/users")
	public User creatUser(@RequestBody User user) {
		return userSerivceImpl.creatUser(user);
	}// creatUser

	// getUserbyId
	@GetMapping("/users/{id}")
	public Optional<User> getUserbyId(@PathVariable("id") Long id) {
		return userSerivceImpl.getUserById(id);
	}// getUserbyId

	// updateUserById
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		return userSerivceImpl.updateUserById(id, user);
	}// updateUserById

	
	 @GetMapping("/users/byUserName/{username}") public User
	 getUserByName(@PathVariable("username") String username) {
		 return	 userSerivceImpl.findByUsername(username); }//getUserbyId
	 

}// UserController.CLASS
