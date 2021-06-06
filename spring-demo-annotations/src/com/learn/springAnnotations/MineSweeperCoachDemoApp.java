package com.learn.springAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MineSweeperCoachDemoApp {

	public static void main(String[] args) {
		
		//create COntext
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SweeperConfig.class);
		
		//retrieve bean
		MineSweeperCoach theCoach = context.getBean("mineSweeperCoach",MineSweeperCoach.class);
		
		//call methods
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//close context
		context.close();
		
	}

}
