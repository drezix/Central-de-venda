package backend.saleproject.models;

import jakarta.persistence.*;

@Entity
public class Sale {
    @Id
    @GeneratedValue
    private Long id;

    private String saleDate;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
