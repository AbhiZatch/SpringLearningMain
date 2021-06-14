package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class UpdateEmployeeDemo {

	public static void main(String[] args) {
		
		//crete session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			String sqlQuery = "Update Employee Set firstName='Scooby' where id='2'";
			
			//create Query
			session.createQuery(sqlQuery).executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			
			factory.close();
		}

	}

}
