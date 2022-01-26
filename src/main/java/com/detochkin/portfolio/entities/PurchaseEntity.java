package com.detochkin.portfolio.entities;


import javax.persistence.*;


@Entity
@Table(name = "purchase_table")
public class PurchaseEntity {

    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "purchase_ticker")
    private String ticker;
    @Column(name = "purchase_price")
    private Double purchasePrice;
    @Column(name = "purchase_quantity")
    private int quantity;
    @Column(name = "purchase_date")
    private String purchaseDate;

    public PurchaseEntity() {
    }


    public String getPurchaseDate() {
        return purchaseDate;
    }

    public Double getPurchaseSum() {
        return purchaseSum;
    }

    private Double purchaseSum;

    public PurchaseEntity(String ticker, Double purchasePrice, int quantity, String purchaseDate) {

        this.ticker = ticker;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.purchaseSum = purchasePrice * quantity;
        this.purchaseDate = purchaseDate;
    }

    public Long getId() { return id;}

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

}
