package com.learn.springAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SweeperConfig {

	@Bean
	public FortuneService mineFortune() {
		MineFortune fortune = new MineFortune();
		return fortune;
	}
	
	@Bean
	public Coach mineSweeperCoach() {
		MineSweeperCoach mineCoach = new MineSweeperCoach(mineFortune());
		return mineCoach;
	}
}
