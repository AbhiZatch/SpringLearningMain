package com.springDemo;

public class TrackCoach implements Coach {
	
	public TrackCoach() {}
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run 30k per day";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	//add an init method for bean init :
	public static void doMyStartupStuff() {
		System.out.println("TrackCoach : inside doMyStartupStuff");
	}

	//add an destroy method :
	public static void doMyCleanStuff() {
		System.out.println("TrackCoach : inside doMyCleanStuff");
	}
}
