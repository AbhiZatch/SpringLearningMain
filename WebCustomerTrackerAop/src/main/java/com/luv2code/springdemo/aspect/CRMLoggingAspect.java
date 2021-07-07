package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName()); 
	
	//setup pointcut decalarations
	@Pointcut("execution(* com.luv2code.springdemo.comtroller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		
		//method name
		System.out.println("-----> Method : "+theJoinPoint.getSignature().toShortString());
		
		//display arguments passing in method
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArgs:args)
			System.out.println(tempArgs);
		
		
	}
	
	//add @After Returning advice
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void after(JoinPoint theJoinPoint,Object result) {
		
		//method name
		System.out.println("-----> Method : "+theJoinPoint.getSignature().toShortString());
				
		//display data returned
		System.out.println("----> Result" +result);
		
	}
	
}
