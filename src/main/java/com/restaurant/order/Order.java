package com.restaurant.order;

import lombok.Data;

@Data
public class Order {
    private String mainCurse;
    private String dessert;
    private String drink;
    private double price;
    private boolean ice;
    private boolean lemon;

    public Order(String mainCurse, String dessert, String drink, double price, boolean ice, boolean lemon) {
        this.mainCurse = mainCurse;
        this.dessert = dessert;
        this.drink = drink;
        this.price = price;
        this.ice = ice;
        this.lemon = lemon;
    }
}
