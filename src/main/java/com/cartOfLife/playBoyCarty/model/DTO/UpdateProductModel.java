package com.cartOfLife.playBoyCarty.model.DTO;

import java.math.BigDecimal;

import com.cartOfLife.playBoyCarty.model.Category;

import lombok.Data;

@Data
public class UpdateProductModel {

    private long id;
    private String name;
    private BigDecimal price;
    private String brand;
    private int inventory;
    private String description;
    private Category category;
}
