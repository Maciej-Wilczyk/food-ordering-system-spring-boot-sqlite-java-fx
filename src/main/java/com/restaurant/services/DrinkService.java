package com.restaurant.services;

import com.restaurant.drinks.Drink;
import java.util.List;

public interface DrinkService {
    Drink add(Drink drink);
    List<Drink> getAll();
}
