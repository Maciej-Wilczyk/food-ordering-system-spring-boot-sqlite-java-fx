package com.restaurant.services;

import com.restaurant.cuisines.Cuisine;
import com.restaurant.cuisines.PolishCuisine;
import com.restaurant.repositories.PolishCuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("polish")
public class PolishCuisineServiceImpl implements CuisineService<PolishCuisine> {
    @Autowired
    private PolishCuisineRepository polishCuisineRepository;
    @Override
    public Cuisine add(PolishCuisine cuisine) {
        return polishCuisineRepository.save(cuisine);
    }
    @Override
    public List<PolishCuisine> getAll() {
        return polishCuisineRepository.findAll();
    }
}
