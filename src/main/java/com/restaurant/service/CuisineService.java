package com.restaurant.service;

import com.restaurant.model.Cuisine;

import java.util.List;

public interface CuisineService {
    Cuisine add(Cuisine cuisine);

    List<Cuisine> getAll();
}
