package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n---> Executing before advice on addAccount()");
		
		//display the method signature
		MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method : "+methoSig);
		
		//display the method arguments
		
		//get the args and then loop thru args
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArg:args) {
			
			System.out.println(tempArg);
			
			//downcast and print account specific stuff
			if(tempArg instanceof Account) {
				
				Account theAccount = (Account) tempArg;
				System.out.println("Account Name : "+theAccount.getName());
				System.out.println("Account Level : "+theAccount.getLevel());
				
			}
			
		}
		
	}
	
	
}
