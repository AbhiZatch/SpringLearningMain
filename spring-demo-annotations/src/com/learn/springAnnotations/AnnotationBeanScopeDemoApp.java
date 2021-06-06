package com.learn.springAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bena from spring container
		Coach myCoach = context.getBean("theTennisCoach",Coach.class);
		Coach newCoach = context.getBean("theTennisCoach",Coach.class);
		
		//check if they are same
		boolean result = (myCoach == newCoach);
		
		//print results
		System.out.println(result);
		System.out.println("Memory Location of myCoach : "+myCoach);
		System.out.println("Memory Location of newCoach : "+newCoach);
		
		//close context
		context.close();

	}

}
