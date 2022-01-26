package com.detochkin.portfolio.controllers;

import com.detochkin.portfolio.entities.PurchaseEntity;
import com.detochkin.portfolio.repos.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping("/purchases")
    String getPurchases(Model model) {
        model.addAttribute("purchase_header", "Последние сделки:");
        Iterable<PurchaseEntity> purchaseEntities = purchaseRepository.findAll();
        model.addAttribute("purchases", purchaseEntities);
        return "purchases";
    }

    @GetMapping("/purchases/{id}")
    String purchaseDetails(@PathVariable(value = "id") Long id, Model model) {
        if (!purchaseRepository.existsById(id))
            return "redirect:/purchases";
        Optional<PurchaseEntity> purchaseEntity = purchaseRepository.findById(id);
        ArrayList<PurchaseEntity> result = new ArrayList<>();
        purchaseEntity.ifPresent(result :: add);
        model.addAttribute("purchase", result);
        return "purchase-details";
    }

    @GetMapping("/purchases/{id}/edit")
    String purchaseEdit(@PathVariable(value = "id") Long id, Model model) {
        if (!purchaseRepository.existsById(id))
            return "redirect:/purchases";
        Optional<PurchaseEntity> purchaseEntity = purchaseRepository.findById(id);
        ArrayList<PurchaseEntity> result = new ArrayList<>();
        purchaseEntity.ifPresent(result :: add);
        model.addAttribute("purchase", result);
        return "purchase-edit";
    }

    @PostMapping("/purchases/{id}/edit")
    String purchaseUpdate(@PathVariable(value = "id") Long id, @RequestParam String ticker,
                          @RequestParam Double price, @RequestParam int quantity,
                          @RequestParam String purchase_date, Model model) {
        PurchaseEntity purchaseEntity = purchaseRepository.findById(id).orElseThrow();
        purchaseEntity.setTicker(ticker);
        purchaseEntity.setPurchasePrice(price);
        purchaseEntity.setQuantity(quantity);
        purchaseEntity.setPurchaseDate(purchase_date);
        purchaseRepository.save(purchaseEntity);
        return "redirect:/purchases";
    }

    @PostMapping("/purchases/{id}/remove")
    String purchaseRemove(@PathVariable(value = "id") Long id, Model model) {
        PurchaseEntity purchaseEntity = purchaseRepository.findById(id).orElseThrow();
        purchaseRepository.delete(purchaseEntity);
        return "redirect:/purchases";
    }

    @GetMapping("/purchases/add")
    String purchaseAdd(Model model) {
        return "purchases-add";
    }

    @PostMapping("/purchases/add")
    String purchaseAdd(@RequestParam String ticker, @RequestParam Double price,
                            @RequestParam int quantity, @RequestParam String purchase_date, Model model) {
        PurchaseEntity purchaseEntity = new PurchaseEntity(ticker, price, quantity, purchase_date);
        purchaseRepository.save(purchaseEntity);
        return "redirect:/purchases";
    }



    @GetMapping("/")
    String getHome(Model model) {
        model.addAttribute("home_header", "Пассивный инвестор");
        return "home";
    }
}
