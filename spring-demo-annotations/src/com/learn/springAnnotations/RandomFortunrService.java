package com.learn.springAnnotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortunrService implements FortuneService {

	//create an array of Strings
	
	private String arr[] = {
			"Good Day",
			"Better Day",
			"Best Day"
	};
	
	//create random number generator
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		
		//pick random number from 
		int index = random.nextInt(arr.length);
		
		return arr[index];
	}

}
