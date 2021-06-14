package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		
		//Create Session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {

			int studentId = 7;
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve the student using id
			System.out.println("Gettnig student with Id : "+studentId);
			Student myStudent = session.get(Student.class,studentId);
			
			System.out.println("Updating Student... : ");
			myStudent.setFirstName("Abhishek");
			
			//commit transaction
			session.getTransaction().commit(); 
			
			//NEW CODE
			
			//get session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//upadte email of all students
			System.out.println("Update email of all students");
			session.createQuery("Update Student s Set s.email='abhishek10men@gmail.com' "
													+ "where s.firstName='Abhishek'").executeUpdate();
			
			//commit Transcation
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}
		

	}

}
