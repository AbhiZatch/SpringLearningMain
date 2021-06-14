package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

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
			Employee theEmployee = new Employee("Abhi565","Zatch","abhiZch121@kn.ioj");
			
			//begin transaction
			session.beginTransaction();
			
			//save session
			session.save(theEmployee);
			
			//getId for employee
			theEmployee = session.get(Employee.class, theEmployee.getId());
			
			System.out.println(theEmployee.getFirstName());
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			
			factory.close();
		}

	}

}
