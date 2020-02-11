package com.infogain.stacksimplify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.stacksimplify.entities.User;
import com.infogain.stacksimplify.exception.UserExistsException;
import com.infogain.stacksimplify.exception.UserNotFoundException;
import com.infogain.stacksimplify.repository.UserRepository;

@Service
public class UserSerivceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
		
	}
	public User creatUser(User user) throws UserExistsException{
		String username=user.getUsername();
		User existingUser=userRepository.findByUsername(username) ;
		if(existingUser!=null) {
			throw new UserExistsException("User Already" +username  +"Exists");
		}
		return userRepository.save(user);
		
	}
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> optionalUser=userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("Current User Id " +id +" Is Not Present");
		}
		return optionalUser;
		
	}
	
	public User updateUserById(Long id,User user) throws UserNotFoundException {
		Optional<User> optionalUser=userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("Current User Id " +id +" Is Not Present , Please Provide Correct User Id");
		}
	     user.setId(id);			
		 return userRepository.save(user) ;
		
	}
	

	public User findByUsername(String username) {	    		
		 return userRepository.findByUsername(username) ;
		 
	}
	
	public void deleteUserById(Long id) throws UserNotFoundException {
		Optional<User> optionalUser=userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("Current User Id " +id +" Is Not Present , Please Provide Correct User Id");
		}
		userRepository.deleteById(id);
		
	}
	
}
