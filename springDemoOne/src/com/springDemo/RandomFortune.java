package com.springDemo;

import java.util.Random;

public class RandomFortune implements FortuneService {
	
	//array for fortunes
	private String randomFortune[] = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	//random number generator
	Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		
		//get random from array
		int ran = myRandom.nextInt(randomFortune.length);
		return randomFortune[ran];
	}

}
