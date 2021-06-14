package com.luv2code.hibernate.demo;

import java.util.Date;

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
			String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
            Student tempStudent = new Student("Pauly", "Doe", "paul@luv.com", theDateOfBirth);
			Student tempStudent1 = new Student("AbhiZatch", "Kumar", "abhishek200men@gmail.com", theDateOfBirth);
			Student tempStudent2 = new Student("Charles", "Downey", "charles.downey@campus.mccd.edu", theDateOfBirth);
			Student tempStudent3 = new Student("Naughty", "Boy", "naughytboy@yopmail.com", theDateOfBirth);

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
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			
			factory.close();
		}

	}

}
