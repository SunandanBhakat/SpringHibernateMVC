package com.pack.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.CustomerDao;
import com.pack.form.Customer;

//To indicate Service layer class
@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;
	
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	
	@Override
	//To indicate Transaction and commit takes place in the service layer
	@Transactional
	public void addCustomer(Customer c) {
		customerDao.addCustomer(c);
		
		
	}

	@Override
	@Transactional
	public void updateCustomer(Customer c) {
		
		customerDao.updateCustomer(c);
		
		
	}

	@Override
	@Transactional
	public Customer getCustomerById(int customerId) {
		
		
		
		return customerDao.getCustomerById(customerId);
	}

	@Override
	@Transactional
	public List<Customer> listCustomer() {
		
		List<Customer> list=customerDao.listCustomer();
		return list;
	}

	@Override
	@Transactional
	public void removeCustomer(int customerId) {
		customerDao.removeCustomer(customerId);
		
	}

}
