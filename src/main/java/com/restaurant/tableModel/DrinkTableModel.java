package com.restaurant.tableModel;

import lombok.Data;

@Data
public class DrinkTableModel {
    private String drink;
    private double price;

    public DrinkTableModel(String drink, double price) {
        this.drink = drink;
        this.price = price;
    }
}
