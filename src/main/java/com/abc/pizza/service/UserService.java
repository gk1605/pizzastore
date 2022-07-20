package com.abc.pizza.service;

import org.springframework.stereotype.Service;

import com.abc.pizza.exceptions.InvalidUserException;

@Service
public interface UserService 
{
	public String login(String username,String password) throws InvalidUserException;

	public boolean logout(String username);
}
