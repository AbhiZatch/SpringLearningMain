package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService",
													TrafficFortuneService.class);
		
		System.out.println("\nMain program : AroundDemoApp");
		
		System.out.println("Calling get Fortune");
		
		boolean tripFlag = true;
		String data = fortuneService.getFortune(tripFlag);
		
		System.out.println(data);
		
		//close the context
		context.close();

	}

}
