package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.entity.FlowerRateDetails;
import com.company.service.FlowerRateDetailsService;
import com.company.service.FlowerService;
/**
 * @author sayandh
 * @date 11/22/2026
 * 
 */
@Controller
@RequestMapping("/flower-rate")
public class FlowerRateDetailsController {
	@Autowired
	private FlowerRateDetailsService flowerRateDetailsService;
	@Autowired
	private FlowerService flowersService;
	
	
	@GetMapping({"/","/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/add")
	public String insertRateDetails(Model model) {
		model.addAttribute("flowerRate", new FlowerRateDetails());
		model.addAttribute("flowers",flowersService.getAllFlowerIdName());
		return "add-rate";
	}
	@PostMapping("/save")
	public String saveRateDetails(@ModelAttribute FlowerRateDetails flowerRate) {
		 	flowerRateDetailsService.saveCustomerOrder(flowerRate);
		 	return "redirect:/flower-rate/list";
	
	}
	
	@GetMapping("/list")
	public String viewRateOrders(Model model) {
		model.addAttribute("flowerRate", flowerRateDetailsService.ShowCustomerOrders());
		return "flower-rate";
	}
	
	@GetMapping("/edit/{flowerRateId}")
	public String modifyOrderRateById(@PathVariable Integer flowerRateId,Model model) {
		model.addAttribute("flowerRate", flowerRateDetailsService.updateCustomerOrderDateById(flowerRateId));
		model.addAttribute("flowers",flowersService.getAllFlowerIdName());
		return "edit-flowerRate-details";
	}

	@PostMapping("/update/{flowerRateId}")
	public String updateOderRateById(@PathVariable Integer flowerRateId,@ModelAttribute FlowerRateDetails flowerRate) {
			flowerRate.setFlowerRateId(flowerRateId);
		 	flowerRateDetailsService.saveCustomerOrder(flowerRate);
		 	return "redirect:/flower-rate/list";
		
	}
	
	
	
	
	

}
