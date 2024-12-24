package com.pasanabeysekara.securitywithswagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pasanabeysekara.securitywithswagger.entity.meta.User;
import com.pasanabeysekara.securitywithswagger.service.User1Service;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private User1Service user1Service;
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
	{
		return user1Service.addUser(user);
	}
	
	@PostMapping("/deleteuser{id}")
	public void deletUserById(@RequestBody User user)
	{
		user1Service.deleteUserById(user);
	}
	
	@GetMapping("/getuser")
		public List<User> getAlluser(@RequestBody User user)
		{
			return user1Service.getAllUser(user);
		}
	
	@PostMapping("/updateUser{id}")
	public void updateUser(@RequestBody User user)
	{
		user1Service.updateUser(user);
	}

}
