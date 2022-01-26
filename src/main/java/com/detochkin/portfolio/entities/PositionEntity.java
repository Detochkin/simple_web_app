package com.detochkin.portfolio.entities;

import javax.persistence.*;

@Entity
@Table(name = "positions_table")
public class PositionEntity {
    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "position_ticker")
    private String ticker;
    @Column(name = "position_avg_price")
    private int positionAvgPrice;
    @Column(name = "position_quantity")
    private int quantity;

    public PositionEntity(String ticker, int positionAvgPrice, int quantity) {
        this.ticker = ticker;
        this.positionAvgPrice = positionAvgPrice;
        this.quantity = quantity;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getPositionAvgPrice() {
        return positionAvgPrice;
    }

    public void setPositionAvgPrice(int positionAvgPrice) {
        this.positionAvgPrice = positionAvgPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
