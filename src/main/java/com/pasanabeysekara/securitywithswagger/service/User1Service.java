package com.pasanabeysekara.securitywithswagger.service;

import java.util.List;

import com.pasanabeysekara.securitywithswagger.entity.meta.User;

public interface User1Service {
	User addUser(User user);
	
	void deleteUserById(User user);
	
	List<User> getAllUser(User user);
	
	void updateUser(User user);

}
