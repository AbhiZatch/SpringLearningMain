package com.springDemo;

public class BaseballCoach implements Coach{
	
	//define a private field for the dependency
	private FortuneService fortuneService;
	
	//define constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "take 30 min daily workout";
	}

	@Override
	public String getDailyFortune() {
		
		//use the fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
