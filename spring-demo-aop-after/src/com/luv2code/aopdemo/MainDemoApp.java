package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//get membership bean
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account theAccount = new Account();
		
		//call the business method
		theAccountDAO.addAccount(theAccount,true);
		theAccountDAO.doWork();
		
		//call getter and setters for AccountDAO
		theAccountDAO.setName("Ganesha");
		theAccountDAO.setServiceCode("HelpMe");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		//do it again
		theMembershipDAO.addAccount();
		theMembershipDAO.gotoSleep();
		
		//close the context
		context.close();

	}

}
