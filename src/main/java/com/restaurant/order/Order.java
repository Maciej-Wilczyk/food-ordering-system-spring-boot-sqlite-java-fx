package com.restaurant.order;

import com.restaurant.drinks.Drink;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class Order {

    private String mainCurse;
    private String dessert;
    private String drink;
    private double price;
    private boolean ice;
    private boolean lemon;
}
