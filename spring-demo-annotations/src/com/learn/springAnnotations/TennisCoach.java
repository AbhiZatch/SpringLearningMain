package com.learn.springAnnotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("theTennisCoach")
//@Scope("prototype") //bean Scope is singleton by default
public class TennisCoach implements Coach {

	//Field injection using Annotation
	@Autowired
	@Qualifier("randomFortunrService")
	private FortuneService fortuneService;
	
	//define an init method:
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Do my startUP stuff");
	}
	
	//define destroy method
	@PreDestroy
	public void doMyDestructiveMehtod() {
		System.out.println("Destructive method call");
	}
	
	/*
	//Constructor injection using Annotations
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	/*
	//Setter Injection using Annotations
	@Autowired
	public void setNewFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	//Method Injection using Annotations
	@Autowired
	public void methodInject(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "From TennisCaoch : Practice Serving 30 minutes";
	}
	
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
