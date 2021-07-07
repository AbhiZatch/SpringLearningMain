package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call the method to find the accounts
		List<Account> myAccounts = null;
		
		try {
			
			//add boolean flag to simulate exception
			boolean tripFlag = false;
			myAccounts = theAccountDAO.findAccounts(tripFlag);
			
		}catch(Exception e) {
			System.out.println("\n Caught Exception : "+e);
		}
		
		//display the accounts
		System.out.println("\n\n Main Programs : After ThrowingDEMOAPP");
		System.out.println("-----");
		System.out.println(myAccounts);
		
		
		//close the context
		context.close();

	}

}
