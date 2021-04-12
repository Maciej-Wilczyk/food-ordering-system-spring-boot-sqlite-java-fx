package com.restaurant.services;

import com.restaurant.drinks.Drink;
import com.restaurant.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    @Override
    public Drink add(Drink drink) {
        return drinkRepository.save(drink);
    }

    @Override
    public List<Drink> getAll() {
        return drinkRepository.findAll();
    }
}
