package com.infogain.stacksimplify.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.stacksimplify.model.UserDetails;

@RestController
@RequestMapping("/myhello")
public class HelloWorldController {
	
	@GetMapping("/helo")
	public String helloWorld() {
		return "hello";
	}
	@GetMapping("/userDetail")
	public UserDetails inforamation() {
		return new UserDetails("prasanta","routray","Gholapur");
		
	}

}
