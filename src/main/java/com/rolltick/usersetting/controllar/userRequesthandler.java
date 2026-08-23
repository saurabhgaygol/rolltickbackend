package com.rolltick.usersetting.controllar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rolltick.usersetting.entity.usertableentity;
import com.rolltick.usersetting.service.userService;

@RestController
@RequestMapping("/api/user")
public class userRequesthandler {
	
	@Autowired
	private userService userservice;
	

	    @PostMapping("/create")
	    public ResponseEntity<usertableentity> createUser(
	            @RequestBody usertableentity user) {

	        usertableentity savedUser =
	        		userservice.createUser(user);

	        return ResponseEntity.ok(savedUser);
	    }
	}
