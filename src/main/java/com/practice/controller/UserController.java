package com.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {
	
	@GetMapping("/getUser")
	public User getUser() {
		log.info("I am in UserController");
		User u1 = new User();
		u1.setAge(1);
		u1.setName("Ambika");
		return u1;
		
	}

}
