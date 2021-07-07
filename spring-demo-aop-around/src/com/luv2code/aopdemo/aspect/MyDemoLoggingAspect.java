package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	//add a new advice for @AfterReturning 
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturingFindAccountAdvice(JoinPoint theJoinPoint,List<Account> result) {
		
		//print out the method on which the advice in performed
		System.out.println("\n----> Executing @AfterReturning on method");
		System.out.println(theJoinPoint.getSignature().toShortString());
		
		//print out the result
		System.out.println("------> result is : "+result);
		
		//modify/post process the data : 
		
		//convert the account names to all upperCase
		convertAccountNamesToUpperCase(result);
		
		//print out the result
		System.out.println("------> result is : "+result);
		
		
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		//loop in the result and change the names to uppercase
		for(Account accountTemp : result) {
			
			// update the name
			accountTemp.setName(accountTemp.getName().toUpperCase());
			
		}	
		
	}
	
	
	//add new Advice for @AfterThrowing
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint,Throwable theExc) {
	
		//print out the method name on which we are advicing on
		System.out.println("After Throwing : "+theJoinPoint.getSignature().toShortString());
		
		//log the exception
		System.out.println("\n-----> theException is : "+theExc);
		
	}
	
	//add new Advice for @After
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccount(JoinPoint theJoinPoint) {
		
		//printOut the method name
		System.out.println("\n----> method name @After adviced called upon"
								+theJoinPoint.getSignature().toShortString());
		
		System.out.println("Executing @After finally advice");
		
	}
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundFortuneService(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		//print out the method we are advicing on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n----> Executing @Around on method : "+method);
		
		//get the begin timeStamp
		long begin = System.currentTimeMillis();
		
		//execute the method
		Object result = theProceedingJoinPoint.proceed();
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		long duration = end - begin;
		System.out.println("\n----> Duration "+duration/1000.0 +"seconds");
		
		return null;
		
	}
	
	
}
