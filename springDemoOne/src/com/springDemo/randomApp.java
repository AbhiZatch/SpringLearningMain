package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class randomApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		RandomCoach theCoach = context.getBean("randomCoach",RandomCoach.class);
		
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
	}

}
