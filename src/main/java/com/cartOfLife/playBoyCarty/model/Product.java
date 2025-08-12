package com.cartOfLife.playBoyCarty.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
// @AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private BigDecimal price;
    private String brand;

    private int inventory;
    private String description;
    // @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "category_id")
    // private Category category;
    // @OneToMany(mappedBy = "product", cascade = CascadeType.ALL) // all images associated with that prodict will be deleted
    // private List<Image> images;

    public Product(String brand, String description, int inventory, String name, BigDecimal price) {
        this.brand = brand;
        // this.category = category;
        this.description = description;
        this.inventory = inventory;
        this.name = name;
        this.price = price;
    }
}
