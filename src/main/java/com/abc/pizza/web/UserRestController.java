package com.abc.pizza.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.pizza.dto.LoginDTO;
import com.abc.pizza.exceptions.InvalidUserException;
import com.abc.pizza.service.UserService;
import com.abc.pizza.validation.ValidateEntry;


@RestController
@RequestMapping("/pizza")
public class UserRestController
{

	@Autowired
	UserService userService;
	
	
	@PostMapping("/login")
	public boolean doLogin(@RequestBody LoginDTO loginObj)throws InvalidUserException
	{
		String username = loginObj.getUsername();
		String password = loginObj.getPassword();
		
		if(ValidateEntry.validateNull(username) && ValidateEntry.validateNull(password))
		{
			String role = userService.login(username, password);
			// some code for session handling 
			
			return true;
			
		}
		else
		{
			throw new InvalidUserException("","");
		}
	
	}
	
}
