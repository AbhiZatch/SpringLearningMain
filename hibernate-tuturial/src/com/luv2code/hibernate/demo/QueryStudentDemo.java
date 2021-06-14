package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		
		//Create Session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {

			
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display students
			displayStudents(theStudents);
			
			System.out.println("\n!---------------------! query students with last Name = 'Kumar'");
			
			//query students with last Name = 'Kumar'
			theStudents = session.createQuery("from Student s where s.lastName='Kumar'").getResultList();
			
			//display Students
			displayStudents(theStudents);
			

			System.out.println("\n!---------------------! students with last Name = 'Kumar' and firstName='Abhishek'");
			
			//query students with last Name = 'Kumar' and firstName='Abhishek'
			theStudents = session.createQuery("from Student s where s.lastName='Kumar'"
													+" AND s.firstName='Abhishek'").getResultList();
			
			//display students
			displayStudents(theStudents);
			

			System.out.println("\n!---------------------! students with email ending with gmail.com");
			
			//query students with email ending with gmail.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			//display students
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("\nDone!");
			
		}
		finally {
			factory.close();
		}
		

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
