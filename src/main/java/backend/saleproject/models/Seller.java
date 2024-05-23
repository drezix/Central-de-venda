package backend.saleproject.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Seller {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "vendedor")
    private List<Sale> sales;

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

}
