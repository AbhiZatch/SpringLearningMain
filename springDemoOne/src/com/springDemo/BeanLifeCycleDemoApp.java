package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		//load Spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		//retreive bean from Spring COntainer
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		//call methods
		System.out.println(theCoach.getDailyFortune());
		
		//close 
		context.close();
	}

}
