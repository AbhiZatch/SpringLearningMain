package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		//simulate a delay
		try {
			
			TimeUnit.SECONDS.sleep(5);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//return a fortune
		return "Expect a heavy traffic today";
		
	}

	public String getFortune(boolean tripFlag) {
		
		if(tripFlag) {
			
			throw new RuntimeException("Major Accident, HighWay is Closed");
			
		}
		
		return null;
	}

}
