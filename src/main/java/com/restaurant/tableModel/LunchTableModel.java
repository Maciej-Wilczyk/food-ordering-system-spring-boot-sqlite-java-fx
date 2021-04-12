package com.restaurant.tableModel;

import lombok.Data;

@Data
public class LunchTableModel {
    private String mainCurse;
    private String dessert;
    private double price;

    public LunchTableModel(String mainCurse, String dessert, double price) {
        this.mainCurse = mainCurse;
        this.dessert = dessert;
        this.price = price;
    }
}
