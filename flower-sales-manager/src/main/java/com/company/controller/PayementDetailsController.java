package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.entity.PayementDetails;
import com.company.entity.SalesDetails;
import com.company.service.PaymentService;


@Controller
@RequestMapping("/payments")
public class PayementDetailsController {
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping({"/","/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/{saleId}")
	public String addPaymentDetails(@PathVariable Integer saleId,Model model) {
		SalesDetails salesDetails = paymentService.getSalesDetails(saleId);
		 model.addAttribute("salesDetails", salesDetails);
		 model.addAttribute("paymentDetails", new PayementDetails());
		 return "payments";
		
	}
	
	@PostMapping("/save")
	public String savePayment(@ModelAttribute PayementDetails payment,
	                          @RequestParam Integer saleId, Model model) {
	    try {
	        paymentService.completePayment(payment, saleId);
	        return "redirect:/sales-log/show";
	    } catch (RuntimeException e) {
	        model.addAttribute("error", e.getMessage());
	        model.addAttribute("salesDetails", paymentService.getSalesDetails(saleId));
	        model.addAttribute("paymentDetails", payment);
	        return "payments";
	    }
	}
	
	@GetMapping("/already-paid")
	public String alreadyPaid() {

	    return "already-paid";
	}

}
