package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		//crete session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a employee object with all the data
			System.out.println("creating object");
			Employee theEmployee = new Employee("Abhishek","kumar","abhishek.kumar1210@tcs.com");
			
			//begin transaction
			session.beginTransaction();
			
			//save the object
			System.out.println("Save the Object");
			session.save(theEmployee);
			
			//Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!..");
			
		}
		finally {
			
			factory.close();
		}

	}

}
