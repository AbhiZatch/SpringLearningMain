package com.learn.springAnnotations;


public class MineSweeperCoach implements Coach {

	private FortuneService fortuneService;
	
	public MineSweeperCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Apply Your Brain!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
