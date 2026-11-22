package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.service.RateHistorydDetailsService;

@Controller
@RequestMapping("/rate-history")
public class RateHistorydDetailsController {
	@Autowired
	private RateHistorydDetailsService rateHistorydDetailsService;
	
	@GetMapping({"/","/home"})
		public String home() {
			return "home";
		}

	@GetMapping("/showHistory")
	public String showAllhistory(Model model) {
		model.addAttribute("showHistory", rateHistorydDetailsService.showAllRateHistory());
		return "rate-history";
	}


}


