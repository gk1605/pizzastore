package com.abc.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.pizza.exceptions.InvalidUserException;
import com.abc.pizza.repository.UserRepository;

@Service
public class UserServiceImpl  implements UserService
{
	@Autowired
	UserRepository userRepository;

	@Override
	public String login(String username, String password) throws InvalidUserException {
		// TODO Auto-generated method stub
		String role = userRepository.verifyUser(username, password);
		
		return role;
	}

	@Override
	public boolean logout(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
