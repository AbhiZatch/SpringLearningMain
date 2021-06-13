package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// Create Session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// create a student object
			System.out.println("Creating 3 student object..");
			Student tempStudent1 = new Student("AbhiZatch", "Kumar", "abhishek200men@gmail.com");
			Student tempStudent2 = new Student("Charles", "Downey", "charles.downey@campus.mccd.edu");
			Student tempStudent3 = new Student("Naughty", "Boy", "naughytboy@yopmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving 3 Student Object..");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

			} 
		finally {
			
			factory.close();
		}

	}

}
