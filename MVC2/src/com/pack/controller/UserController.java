package com.pack.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.pack.model.User;
import com.pack.service.UserService;

//SimpleFormController-->deprecated class. so we will use annotations

public class UserController extends SimpleFormController {
	
	private UserService userService;
	
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserController() {
		
		setCommandClass(User.class);
		setCommandName("user");// refers to user in commandName attribute of userForm.jsp
	}

	protected ModelAndView onSubmit(Object command)throws Exception
	{
		User u=(User) command;
		userService.add(u);
		
		//view name+ model name+ model object
		return new ModelAndView("userSuccess","user",u);
	}
	
	

}
