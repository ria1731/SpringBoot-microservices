package com.userService.services;

import java.util.List;

import com.userService.entities.User;

public interface userServices {
    //create
	User saveUser(User user);
	
	//get all user
	List<User> getAllUser();
	
	// get single user of given userId
	User getUser(String userId);
	
	
}
