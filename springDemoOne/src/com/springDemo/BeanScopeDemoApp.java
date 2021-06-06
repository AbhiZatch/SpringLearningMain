package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		//check if the beans are same
		boolean result = (theCoach == alphaCoach) ;
		
		System.out.println("Are they pointing to the same object : "+result);
		System.out.println("Memory loaction for theCoach : "+theCoach);
		System.out.println("Memory loaction for alphaCoach : "+alphaCoach);
		
		
		//close the context
		context.close();

	}
	

}
