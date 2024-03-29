package com.pack.service;

import java.util.List;

import com.pack.form.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer c);
	public void updateCustomer(Customer c);
	public Customer getCustomerById(int customerId);
	public List<Customer> listCustomer();
	public void removeCustomer(int customerId);

}
