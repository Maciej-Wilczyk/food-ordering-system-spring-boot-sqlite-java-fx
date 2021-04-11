package com.restaurant.service;

import com.restaurant.model.Cuisine;
import com.restaurant.repository.CuisineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CuisineServiceImpl implements CuisineService {


    final CuisineRepository cuisineRepository;

    @Override
    public Cuisine add(Cuisine cuisine) {
        return cuisineRepository.save(cuisine);
    }

    @Override
    public List<Cuisine> getAll() {
        return cuisineRepository.findAll();
    }
}
