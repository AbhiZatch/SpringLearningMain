package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		
		//Create Session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {

			//create a student object
			System.out.println("Creating a student object..");
			String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
            Student tempStudent = new Student("Pauly", "Doe", "paul@luv.com", theDateOfBirth);
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object 
			System.out.println("Saving the Student Object..");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("saved student Id : "+tempStudent.getId());
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve the student using id
			System.out.println("Gettnig student with Id : "+tempStudent.getId());
			Student myStudent = session.get(Student.class,tempStudent.getId());
			System.out.println("Get Complete : "+myStudent);
			
			//commmit transaction
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
