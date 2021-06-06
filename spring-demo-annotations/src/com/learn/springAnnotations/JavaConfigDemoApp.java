package com.learn.springAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config file/
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		Coach theCoach = context.getBean("theTennisCoach",Coach.class);
				
		// call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		//close the context
		context.close();	
	}

}
