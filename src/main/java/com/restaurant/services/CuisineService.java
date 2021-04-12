package com.restaurant.services;

import com.restaurant.cuisines.Cuisine;

import java.util.List;

public interface CuisineService<T extends Cuisine>  {
    Cuisine add(T cuisine);

    List<T> getAll();
}
