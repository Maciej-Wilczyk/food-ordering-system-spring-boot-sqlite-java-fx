package com.restaurant.services;

import com.restaurant.cuisines.Cuisine;
import com.restaurant.cuisines.ItalianCuisine;
import com.restaurant.repositories.ItalianCuisineRepository;
import com.restaurant.repositories.MexicanCuisineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("italian")
public class ItalianCuisineServiceImpl implements CuisineService<ItalianCuisine> {

    @Autowired
    private ItalianCuisineRepository italianCuisineRepository;

    @Override
    public Cuisine add(ItalianCuisine cuisine) {
        return italianCuisineRepository.save(cuisine);
    }

    @Override
    public List<ItalianCuisine> getAll() {
        return italianCuisineRepository.findAll();
    }
}
