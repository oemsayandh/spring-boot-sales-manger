package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.entity.Flowers;
import com.company.service.FlowerService;

@Controller
@RequestMapping("/flower-details")
public class FlowerDeatilsController {
	
	@Autowired 
	private FlowerService flowerService;
	
	@GetMapping({"/", "/home"})
	public String home() {
	    return "home";
	}
	
	@GetMapping("/add")
	public String addFlowerDetails(Model model) {
		model.addAttribute("flowers" , new Flowers());
		return "add-flower";
		
	}
	
	@PostMapping("/save")
	public String saveFlowerDetails(@ModelAttribute Flowers flowers) {
		flowerService.insertFlowerDetails(flowers);
		return "redirect:/flower-details/list";
	}
	
	@GetMapping("/list")
	public String showFlowerIdName(Model model) {
		model.addAttribute("flowers", flowerService.getAllFlowerIdName());
		return "flower-details";
	}
	
	

}
