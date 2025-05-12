package com.indev.blackfriday.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.indev.blackfriday.Company;

@Controller
public class WebController {

    private final Company company = new Company();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("totalAssets", company.totalAssets());
        model.addAttribute("salesHistory", company.salesHistory());
        return "index";
    }

    @PostMapping("/stock")
    public String addStock(@RequestParam int quantity,
            @RequestParam String product,
            @RequestParam int price) {
        company.stock(quantity, product, price);
        return "redirect:/";
    }

    @PostMapping("/sell")
    public String sell(@RequestParam String product) {
        company.sells(product);
        return "redirect:/";
    }
}
