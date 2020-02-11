package com.infogain.stacksimplify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.stacksimplify.entities.User;
import com.infogain.stacksimplify.repository.UserRepository;

@Service
public class UserSerivceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
		
	}
	public User creatUser(User user) {
		return userRepository.save(user);
		
	}
	public Optional<User> getUserById(Long id) {
		Optional<User> optionalUser=userRepository.findById(id);		
		return optionalUser;
		
	}
	
	public User updateUserById(Long id,User user) {
	     user.setId(id);			
		 return userRepository.save(user) ;
		
	}
	

	public User findByUsername(String username) {	    		
		 return userRepository.findByUsername(username) ;
		 
	}
	
}
