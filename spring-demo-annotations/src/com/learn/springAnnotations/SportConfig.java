package com.learn.springAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
//@ComponentScan("com.learn.springAnnotations")
public class SportConfig {
	
	//define bean for our fortune service
	@Bean
	public FortuneService randomFortuneService() {
		
		RandomFortunrService randomFortuneService = new RandomFortunrService();	
		return randomFortuneService;
	}
	
	//define bean for our swim and inject dependency
	@Bean 
	public Coach swimCoach() {
		
		SwimCoach swimCoach = new SwimCoach(randomFortuneService());
		return swimCoach;
	}
}
