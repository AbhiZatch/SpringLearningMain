package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//create a student object
		Student theStudent = new Student();
		
		//add object to model
		theModel.addAttribute("student",theStudent);
		
		return "studentForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent,Model theModel) {
		
		//log the input data
		System.out.println(theStudent.getFirstName()+"   "+theStudent.getLastName());
		String firstname = theStudent.getFirstName().toUpperCase();
		
		theModel.addAttribute("message",firstname);
		
		return "studentConfirmation";
	}
}
