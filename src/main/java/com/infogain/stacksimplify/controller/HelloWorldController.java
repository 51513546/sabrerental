package com.infogain.stacksimplify.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myhello")
public class HelloWorldController {
	@GetMapping("/helo")
	public String helloWorld() {
		return "hello";
	}

}
