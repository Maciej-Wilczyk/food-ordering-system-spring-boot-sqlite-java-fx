package com.restaurant.services;

import com.restaurant.drinks.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DrinkService {
    List<Drink> getAll();
}
