package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//create a controller method to show initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//create a controller method to display the form data
	@RequestMapping("/displayData")
	public String displayData() {
		return "displayform-data";
	}
	
	//new controller method to read form data and convert to upper case
	@RequestMapping("/PerformAllCaps")
	public String allCaps(HttpServletRequest request , Model model) {
		
		//get student name(reading request from request)
		String theName = request.getParameter("studentName");
		
		//convert to upperCase
		theName = "Yo! " + theName.toUpperCase();
		
		//Adding to model
		model.addAttribute("message",theName);
		
		return "displayform-data";
	}
	
	@RequestMapping("/PerformAllCaps2")
	public String allCaps2(@RequestParam("studentName") String theName , Model model) {
		
		//convert to upperCase
		theName = "Hey You : " + theName.toUpperCase();
		
		//Adding to model
		model.addAttribute("message",theName);
		
		return "displayform-data";
	}
	
}
