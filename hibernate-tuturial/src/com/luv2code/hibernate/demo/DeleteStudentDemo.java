package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		
		//Create Session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 10;
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//delete the student using id from getting it from session.
			System.out.println("delete student with Id : "+studentId);
			Student myStudent = session.get(Student.class,studentId);
			
			session.delete(myStudent);
			
			//commmit transaction
			session.getTransaction().commit(); 
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//delete student using on the go (using sql query)
			System.out.println("Deleting student");
			session.createQuery("delete from Student where id=8").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}
		

	}

}
