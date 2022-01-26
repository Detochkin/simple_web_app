package com.detochkin.portfolio.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deposit_table")

public class DepositEntity {

    @Id
    @Column(name = "deposit_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "deposit_sum")
    private Double depositSum;

    @Column(name = "deposit_source")
    private String source;


    @Column(name = "deposit_date")
    @Temporal(TemporalType.DATE)
    private Date depositDate;
    public DepositEntity() {
    }

    public DepositEntity(Date depositDate, Double depositSum, String source) {
        this.depositDate = depositDate;
        this.depositSum = depositSum;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDepositSum() {
        return depositSum;
    }

    public void setDepositSum(Double depositSum) {
        this.depositSum = depositSum;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }
}
