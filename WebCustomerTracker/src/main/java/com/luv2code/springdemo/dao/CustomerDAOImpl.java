package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject hibernate session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName"
																,Customer.class);
		
		//execute query and get the result list
		List<Customer> customers = theQuery.getResultList();
		
		//return the result
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		//get current hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//saving or update to DB
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrive the data from DB using the primary Key passed in parameter
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create a query using HQL to delete customer with primary key(id)
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerid");
		theQuery.setParameter("customerid", theId);
		
		theQuery.executeUpdate();
		
		/*
		 * Second way to delete a customer without HQL
		//get the customer with the id
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		//delete the customer
		currentSession.delete(theCustomer);
		*/
		
	}

	@Override
	@Transactional
	public List<Customer> getCustomers(String theSearchName) {
		
		
		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create Query to get the resultList
		Query theQuery = currentSession.createQuery("from Customer where firstName like :name",
															Customer.class);
		theQuery.setParameter("name", theSearchName);
		
		List<Customer> theCustomer = theQuery.getResultList();
		
		return theCustomer;
	}

}
