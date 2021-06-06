package com.learn.springAnnotations;

import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "From Chess Coach : Protect Queen";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
