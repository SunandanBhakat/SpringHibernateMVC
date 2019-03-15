package com.pack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.pack.form.Customer;

//To indicate repository layer for datatabase communication
@Repository
public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory sessionFactory;
	

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override

	public void addCustomer(Customer c) {
		sessionFactory.getCurrentSession().save(c);

	}

	@Override
	public void updateCustomer(Customer c) {
		sessionFactory.getCurrentSession().update(c);

	}

	@Override
	public Customer getCustomerById(int customerId) {
		Session session=sessionFactory.getCurrentSession();
		Customer customer=(Customer) session.get(Customer.class, customerId);
		
		return customer;
	}

	@Override
	public List<Customer> listCustomer() {

		return sessionFactory.getCurrentSession().createQuery("FROM Customer").list();
	}

	@Override
	public void removeCustomer(int customerId) {
		
		Session session=sessionFactory.getCurrentSession();
		Customer customer=(Customer) session.get(Customer.class, customerId);
		
		if(customer!=null)
		{
			session.delete(customer);
		}

	}

}
