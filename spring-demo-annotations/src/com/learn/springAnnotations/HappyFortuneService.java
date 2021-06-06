package com.learn.springAnnotations;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Best Day for You! Don't Underestimate Youself";
	}

}
