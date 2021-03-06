package com.infogain.stacksimplify.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.infogain.stacksimplify.entities.User;
import com.infogain.stacksimplify.exception.UserExistsException;
import com.infogain.stacksimplify.exception.UserNameNotFoundException;
import com.infogain.stacksimplify.exception.UserNotFoundException;
import com.infogain.stacksimplify.service.UserSerivceImpl;

//Controller
@RestController
@Validated
@RequestMapping(value="/users")
public class UserController {

	// Autowired the services class

	@Autowired
	private UserSerivceImpl userSerivceImpl;

	@GetMapping
	public List<User> getAllUser() {
		return userSerivceImpl.getAllUsers();

	}// getAllUser

	// creatUser
	@PostMapping
	public ResponseEntity<Void> creatUser(@Valid @RequestBody User user,UriComponentsBuilder builder) {
		try {
			userSerivceImpl.creatUser(user);
			HttpHeaders headers=new HttpHeaders();
			headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		} catch (UserExistsException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,e.getMessage());
		}
	}// creatUser

	// getUserbyId
	@GetMapping("/{id}")
	public Optional<User> getUserbyId(@Min(1) @PathVariable("id") Long id) {
		try {
			return userSerivceImpl.getUserById(id);
		} catch (UserNotFoundException une) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, une.getMessage());
		}
	}// getUserbyId

	// updateUserById
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		try {
			return userSerivceImpl.updateUserById(id, user);
		} catch (UserNotFoundException unfe) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, unfe.getMessage());
		}
	}// updateUserById

	@GetMapping("/byUserName/{username}")
	public User getUserByName(@PathVariable("username") String username,UriComponentsBuilder builder) throws UserNameNotFoundException {
		User user= userSerivceImpl.findByUsername(username);
		if(user==null) {
			throw new UserNameNotFoundException(username +" Username is not exist");
		}
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
		
		return user;
	}// getUserbyId

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		try {
			userSerivceImpl.deleteUserById(id);
		} catch (UserNotFoundException unfe) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, unfe.getMessage());
		}
	}// deleteUserById

}// UserController.CLASS
