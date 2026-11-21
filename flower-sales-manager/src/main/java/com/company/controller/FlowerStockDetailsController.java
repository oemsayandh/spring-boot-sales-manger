
package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.entity.FlowerStockDetails;
import com.company.service.FlowerService;
import com.company.service.FlowerStockDetailsService;

@Controller
@RequestMapping("/flower-stock-details")
public class FlowerStockDetailsController {
	/**
	 * @author sayandh
	 * @date 11/20/2026
	 * 
	 */
    @Autowired
    private FlowerStockDetailsService flowerStockDetailsService;

    @Autowired
    private FlowerService flowerService;

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/add")
    public String insertStockDetails(Model model) {

        model.addAttribute("flowerStockDetails",
                new FlowerStockDetails());

        model.addAttribute("flowers",
                flowerService.getAllFlowerIdName());

        return "add-stock-details";
    }

    @PostMapping("/save")
    public String saveStockDetails(
            @ModelAttribute FlowerStockDetails flowerStockDetails) {

        flowerStockDetailsService.addStockDetails(flowerStockDetails);

        return "redirect:/flower-stock-details/list";
    }

    @GetMapping("/list")
    public String showAllStockDetails(Model model) {

        model.addAttribute("flowerStockDetails",
                flowerStockDetailsService.ShowStockDetails());

        return "flower-stock-details";
    }

    @GetMapping("/edit/{stockId}")
    public String modifyStockById(
            @PathVariable int stockId, Model model) {

        model.addAttribute("flowerStockDetails",
                flowerStockDetailsService.editStockById(stockId));

        model.addAttribute("flowers",
                flowerService.getAllFlowerIdName());

        return "edit-stock-details";
    }

    @PostMapping("/update")
    public String updateStockDetails(
            @ModelAttribute FlowerStockDetails flowerStockDetails) {

        flowerStockDetailsService.addStockDetails(flowerStockDetails);

        return "redirect:/flower-stock-details/list";
    }

    @GetMapping("/delete/{stockId}")
    public String removeStockById(@PathVariable int stockId) {

        flowerStockDetailsService.deleteStockById(stockId);

        return "redirect:/flower-stock-details/list";
    }
}
