package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	
	private String name;
	private String serviceCode;
	
	//add a new method
	public List<Account> findAccounts(boolean tripFlag){
		
		if(tripFlag) {
			throw new RuntimeException("Study hard");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		//create sample accounts
		Account temp1 = new Account("Abhishek","Digital");
		Account temp2 = new Account("Luca","Gold");
		
		//add accounts to the list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		
		return myAccounts;
		
	}
	
	public String getName() {
		System.out.println(getClass()+ ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+ ": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+ ":getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ ": setServiceCode");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount,boolean vipFlag) {
		
		System.out.println(getClass()+ ": Doing my DB Work : Adding an Account");
	}
	
	public void doWork() {
		
		System.out.println(getClass()+" Doing Work");
		
	}
	
}
