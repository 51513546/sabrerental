package com.infogain.stacksimplify.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.stacksimplify.entities.User;
import com.infogain.stacksimplify.service.UserSerivceImpl;

//Controller
@RestController

public class UserController {
  
//Autowired the services class
@Autowired	
private UserSerivceImpl userSerivceImpl;

@GetMapping("/users")
public List<User> getAllUser(){	
	return userSerivceImpl.getAllUsers();
	
}

//create User
//RequestBody annotation
//@postMappping
@PostMapping("/users")
public User creatUser(@RequestBody User user) {
	return userSerivceImpl.creatUser(user);
}

@GetMapping("/users/{id}")
public Optional<User> getUserbyId(@PathVariable("id") Long id) {
	return userSerivceImpl.getUserById(id);
}

}
