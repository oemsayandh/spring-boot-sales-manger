package com.company.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.entity.Customers;
import com.company.entity.SalesSubItemsDetails;
import com.company.service.CustomerService;
import com.company.service.FlowerRateDetailsService;
import com.company.service.FlowerService;
import com.company.service.SalesDetailsService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sales-Details")
public class SalesDetailsController {
	@Autowired
	private SalesDetailsService salesDetailsService;
	@Autowired 
	private FlowerService flowerService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private FlowerRateDetailsService flowerRateDetailsService;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@GetMapping("/add")
    public String addSalesDetails(Model model, HttpSession session) {

        Integer flowerId = (Integer) session.getAttribute("flowerId");

        List<SalesSubItemsDetails> items =
                (List<SalesSubItemsDetails>) session.getAttribute("items");

        if (items == null) items = new ArrayList<>();

        model.addAttribute("addbill", salesDetailsService.getBillno());
        model.addAttribute("customernames", customerService.getAllCustomers());
        model.addAttribute("flowername", flowerService.getAllFlowerIdName());
        model.addAttribute("selectedFlowerId", flowerId);
        model.addAttribute("rates", flowerId == null ? new ArrayList<>()
                : flowerRateDetailsService.getRatesByFlowerId(flowerId));
        model.addAttribute("salesItems", items);

        model.addAttribute("grandTotal", items.stream()
                .mapToDouble(i -> i.getQuantity() * i.getRate()).sum());

        return "sales-Details";
    }


    @PostMapping("/select-flower")
    public String selectFlower(@RequestParam Integer flowerId,
                               HttpSession session) {

        session.setAttribute("flowerId", flowerId);

        return "redirect:/sales-Details/add";
    }


    @PostMapping("/add-item")
    public String addItem(@RequestParam Double quantity,
                          @RequestParam Double rate,
                          HttpSession session) {

        Integer flowerId = (Integer) session.getAttribute("flowerId");

        List<SalesSubItemsDetails> items =
                (List<SalesSubItemsDetails>) session.getAttribute("items");

        if (items == null) items = new ArrayList<>();

        SalesSubItemsDetails item = new SalesSubItemsDetails();

        item.setFlowers(flowerService.getFlowersById(flowerId));
        item.setQuantity(quantity);
        item.setRate(rate);

        items.add(item);

        session.setAttribute("items", items);
        session.removeAttribute("flowerId");

        return "redirect:/sales-Details/add";
    }


    @PostMapping("/save")
    public String saveSalesDetails(@RequestParam Integer customerId,
                                   @RequestParam Date saleDate,
                                   HttpSession session) {

        List<SalesSubItemsDetails> items =
                (List<SalesSubItemsDetails>) session.getAttribute("items");

        Customers customer = customerService.modifyCustomerByID(customerId);

        salesDetailsService.saveDetails(customer, saleDate, items);

        session.removeAttribute("items");
        session.removeAttribute("flowerId");

        return "redirect:/sales-Details/add";
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
