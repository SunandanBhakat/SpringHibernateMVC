package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pack.model.User;
import com.pack.service.UserService;

@Controller
@RequestMapping("/userRegistration.htm")//mapping
@SessionAttributes("user")//command name
public class UserController  {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showForm(ModelMap model)
	{
		User u=new User();
		
		model.addAttribute(u);//mapping
		
		
		return "userForm";
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	
	public String onSubmit(@ModelAttribute("user")User u)
	{
		
		
		userService.add(u);
		
		return "userSuccess";
		
	}
	
	

}
