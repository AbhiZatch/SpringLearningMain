package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addAccount() {
		
		System.out.println(getClass()+" Doing stuff: Adding a membership Firm");
		
		return true;
		
	}
	
	public void gotoSleep() {
		
		System.out.println(getClass()+"Doing gotoSleep");
		
	}
	
}
