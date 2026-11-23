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
	public String savePayment(@ModelAttribute PayementDetails payementDetails,@RequestParam Integer saleId) {
		SalesDetails salesDetails = paymentService.getSalesDetails(saleId);
		//this for excption making for duplication of sale ids and paymnets because of html
		 if (paymentService.isSaleAlredyPaid(saleId)) {
		        return "redirect:/payments/already-paid";
		    }
		payementDetails.setSalesDetails(salesDetails);
		payementDetails.setPaymentAmount(salesDetails.getSaleTotalAmount());
		paymentService.savePayments(payementDetails);
		return "redirect:/sales-Details/add";
	}
	
	@GetMapping("/already-paid")
	public String alreadyPaid() {

	    return "already-paid";
	}

}
