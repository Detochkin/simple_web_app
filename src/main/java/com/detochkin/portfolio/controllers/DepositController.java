package com.detochkin.portfolio.controllers;

import com.detochkin.portfolio.entities.DepositEntity;
import com.detochkin.portfolio.repos.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class DepositController {

    @Autowired
    private DepositRepository depositRepository;

    @GetMapping("/deposits")
    String getdeposits(Model model) {
        Double total = 0.0;
        model.addAttribute("deposit_header", "Пополнения счёта:");
        Iterable<DepositEntity> depositEntities = depositRepository.findAll();
        model.addAttribute("deposits", depositEntities);
        for (DepositEntity depo: depositEntities)
        {
            total += depo.getDepositSum();
        }
        model.addAttribute("deposits_total", total);
        return "deposits";
    }

    @GetMapping("/deposits/{id}")
    String depositDetails(@PathVariable(value = "id") Long id, Model model) {
        if (!depositRepository.existsById(id))
            return "redirect:/deposits";
        Optional<DepositEntity> depositEntity = depositRepository.findById(id);
        ArrayList<DepositEntity> result = new ArrayList<>();
        depositEntity.ifPresent(result :: add);
        model.addAttribute("deposit", result);
        return "deposit-details";
    }

    @GetMapping("/deposits/{id}/edit")
    String depositEdit(@PathVariable(value = "id") Long id, Model model) {
        if (!depositRepository.existsById(id))
            return "redirect:/deposits";
        Optional<DepositEntity> depositEntity = depositRepository.findById(id);
        ArrayList<DepositEntity> result = new ArrayList<>();
        depositEntity.ifPresent(result :: add);
        model.addAttribute("deposit", result);
        return "deposit-edit";
    }

    @PostMapping("/deposits/{id}/edit")
    String depositUpdate(@PathVariable(value = "id") Long id,
                         @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date depositDate,
                          @RequestParam Double depositSum, @RequestParam String source,
                            Model model) {
        DepositEntity depositEntity = depositRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        depositEntity.setDepositDate(depositDate);
        depositEntity.setDepositSum(depositSum);
        depositEntity.setSource(source);
        depositRepository.save(depositEntity);
        return "redirect:/deposits";
    }

    @PostMapping("/deposits/{id}/remove")
    String depositRemove(@PathVariable(value = "id") Long id, Model model) {
        DepositEntity depositEntity = depositRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        depositRepository.delete(depositEntity);
        return "redirect:/deposits";
    }

    @GetMapping("/deposits/add")
    String depositAdd(Model model) {
        return "deposits-add";
    }


    @PostMapping("/deposits/add")
    String depositAdd(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date depositDate,
                      @RequestParam Double depositSum,
                      @RequestParam String source, Model model) {
        DepositEntity depositEntity = new DepositEntity(depositDate, depositSum, source);
        depositRepository.save(depositEntity);
        return "redirect:/deposits";
    }

}
