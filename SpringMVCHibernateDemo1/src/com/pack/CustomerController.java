package com.pack;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.form.Customer;
import com.pack.service.CustomerService;

//To indicate Controller layer class
@Controller

public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping("/index")
	public String listCustomer(Map<String,Object> map)
	{
		map.put("customer", new Customer());//command name map with command object properties
		map.put("customerList", customerService.listCustomer());//send fetched data from database to customerList object
		return "customer";
		
	}
	
	@RequestMapping(value="/customer/add",method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer")Customer customer)//Mapped to command object
	{
		if(customer.getId()==null)
		{
			Random random=new Random();
			int num=random.nextInt(900000)+100000;
			customer.setId(num);
			customerService.addCustomer(customer);
			
		}
		else
		{
			customerService.updateCustomer(customer);
		}
		
		return "redirect:/index";
		
	}
	
	@RequestMapping(value="/edit/{cid}")	//{}--> to denote cid-->url pattern
	public String editCustomer(@PathVariable("cid")Integer customerId,Map<String,Object> map)
	{
		Customer customer =customerService.getCustomerById(customerId);
		map.put("customer",customer);//customer Mapped to command object
		map.put("customerList",customerService.listCustomer());
		return "customer";
	}
	
	@RequestMapping(value="/delete/{cid}")
	public String deleteCustomer(@PathVariable("cid")Integer customerId,Map<String,Object> map)
	{
		customerService.removeCustomer(customerId);
		
		return "redirect:/index";
	}

	
}
