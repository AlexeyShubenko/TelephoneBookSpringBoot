package com.test.javaproject.mvc.service;


import com.test.javaproject.mvc.dto.UserDto;

public interface UserService {

	boolean checkExistingUser(String login);
	void saveUser(UserDto userDto);
	UserDto verifyUser(String login, String password);
	
}
