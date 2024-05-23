package backend.saleproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Seller {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "vendedor nome")
    private String name;

    @Column(name = "total de vendas")
    private Long totalSales;

    @Column(name = "media de vendas")
    private Long salesMedia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Long totalSales) {
        this.totalSales = totalSales;
    }

    public Long getSalesMedia() {
        return salesMedia;
    }

    public void setSalesMedia(Long salesMedia) {
        this.salesMedia = salesMedia;
    }

}
