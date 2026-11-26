package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.service.SalesLogDetailsService;

@Controller
@RequestMapping("/sales-log")
public class SalesLogDetailsController {
	@Autowired
	private SalesLogDetailsService logDetailsService;
	
	@GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }
	
	@GetMapping("/show")
	public String showAllSalesLogs(Model model) {
		model.addAttribute("salesLogs", logDetailsService.showAllSalesLogs());
		return "sales-log";
	}

}
