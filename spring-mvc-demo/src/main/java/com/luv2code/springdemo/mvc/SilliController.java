package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SilliController {

	@RequestMapping("/showForm")
	public String disaplyTheForm() {
		
		return "silly";
	}
}
