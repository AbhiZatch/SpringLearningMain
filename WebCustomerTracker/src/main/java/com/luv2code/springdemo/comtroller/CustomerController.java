package com.luv2code.springdemo.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject the customer Service
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from customerService
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("showFormForAdd")
	public String showFromForAdd(Model theModel) {
		
		//create model attribute to bind the data from form
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);		
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the data from form saved in model using our Service;
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateDetails")
	public String updateDetails(@RequestParam("customerId") int theId , Model theModel) {
		
		//get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model attribute to prepopulate the form
		theModel.addAttribute("customer",theCustomer);
		
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete customer with the id
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("searchCustomer")
	public String searchCustomer(@RequestParam("searchName") String theSearchName, Model theModel) {
		
		//get all customer list with name = searchName
		List<Customer> theCustomer = customerService.getCustomers(theSearchName);
		
		//add the result to Model
		theModel.addAttribute("customers",theCustomer);
		
		return "list-customers";
	}
	
	@GetMapping("/sort")
	public String sort(@RequestParam("sortValue") String theSortValue,Model theModel) {
		
		
		List<Customer> theCustomer = customerService.getCustomers("sort",theSortValue);
		
		//add attribute to model
		theModel.addAttribute("customers",theCustomer);		
		
		return "list-customers";
	}

}
