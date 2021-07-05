package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	
	public void addAccount(Account theAccount,boolean vipFlag) {
		
		System.out.println(getClass()+ ": Doing my DB Work : Adding an Account");
	}
	
	public void doWork() {
		
		System.out.println(getClass()+" Doing Work");
		
	}
}
