package br.dev.correa.springbootproductscrud.Product;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(name = "produc_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;
    private String name;
    private LocalDate createdAt;
    private Float price;

    public Product(Long id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.createdAt = LocalDate.now();
        this.price = price;
    }

    public Product(String name, Float price) {
        this.name = name;
        this.createdAt = LocalDate.now();
        this.price = price;
    }

    public Product() {
    }

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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
