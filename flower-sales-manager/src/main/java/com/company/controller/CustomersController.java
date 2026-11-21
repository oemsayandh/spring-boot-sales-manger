package com.company.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.entity.Customers;
import com.company.service.CustomerService;

@Controller
@RequestMapping("/customer-details")
public class CustomersController {

	@Autowired
	private CustomerService customerService;
	/**
	 * @author sayandh
	 * @date 11/21/2026
	 * 
	 */

	
	@GetMapping({"/","/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/add")
	public String insertCustomerDetails(Model model) {
		model.addAttribute("customerDetails", new Customers() );
		return "add-customer";
	}
	@PostMapping("/save")
	public String saveCustomerDetails(@ModelAttribute Customers customerDetails) {
		customerService.addCustomerDetails(customerDetails);
		return "redirect:/customer-details/list";
	}
	
	@GetMapping("/list")
	public String ShowALlCustomers(Model model) {
		model.addAttribute("customerDetails" ,customerService.getAllCustomers());
		return "customer-details";
	
	}
	@GetMapping("/edit/{customerId}")
	public String editCustomersByid(@PathVariable Integer customerId,Model model) {
		model.addAttribute("customerDetails", customerService.modifyCustomerByID(customerId));
		return "edit-customer-details";
	}
	@PostMapping("/update")
	public String updateCustomerById(@ModelAttribute Customers customerDetails) {
		customerService.addCustomerDetails(customerDetails);
		return "redirect:/customer-details/list";
	}
	
	@GetMapping("/delete/{customerId}")
	public String deleteCustomer(@PathVariable Integer customerId) {
		customerService.deleteCustomerByID(customerId);
		return "redirect:/customer-details/list";
		
	
	}
	}


