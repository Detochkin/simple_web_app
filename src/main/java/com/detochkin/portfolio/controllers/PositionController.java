package com.detochkin.portfolio.controllers;

import com.detochkin.portfolio.repos.PositionRepository;
import com.detochkin.portfolio.repos.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class PositionController {

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/portfolio")
    String getPortfolio(Model model) {
        model.addAttribute("portfolio_header", "Состав портфеля:");
/*        List<PortfolioEntity> portfolioEntityList = getPurchases().findAll();
            return portfolioEntityList;}*/
        return "portfolio";
    }

}
