package com.greenapex.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenapex.quizapp.entity.UserModule;
import com.greenapex.quizapp.service.UserService;

@RestController
public class UserController {
    @Autowired
	UserService userService;
	@PostMapping("/insertuser")
	public UserModule insert(@RequestBody UserModule user) {
		userService.insertUser(user);
		return user;
		}
		@PutMapping("/updateuser")
		public UserModule update(@RequestBody UserModule user) {
			userService.updateUser(user);
			return user;
		}
		 @GetMapping("/getuserbyid/{user_id}")
			public UserModule getById(@PathVariable Integer user_id) {
				return userService.getUserById(user_id);
			}
	    @GetMapping("/getalluser")
		public List<UserModule> getUser() {
			List<UserModule> result=userService.getAllUser();
			return result;
		}
	   
}