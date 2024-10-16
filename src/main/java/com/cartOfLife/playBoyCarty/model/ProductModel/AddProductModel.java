package com.cartOfLife.playBoyCarty.model.ProductModel;

import java.math.BigDecimal;

import com.cartOfLife.playBoyCarty.model.Category;

import lombok.Data;

@Data
public class AddProductModel {

    private String name;
    private BigDecimal price;
    private String brand;
    private int inventory;
    private String description;
    private Category category;
}
