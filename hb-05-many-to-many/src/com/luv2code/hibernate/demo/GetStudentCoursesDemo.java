package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class GetStudentCoursesDemo {

	public static void main(String[] args) {
		
		
		//Create Session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			//start a transaction
			session.beginTransaction();
			
			//get the student from DB
			int theId = 1;
			Student tempStudent = session.get(Student.class, theId);
			System.out.println("Student : "+tempStudent.getFirstName());
			System.out.println("Coursess enrolled : "+tempStudent.getCourses());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
