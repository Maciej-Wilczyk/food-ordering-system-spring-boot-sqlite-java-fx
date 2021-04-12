package com.restaurant.services;

import com.restaurant.cuisines.Cuisine;
import com.restaurant.cuisines.MexicanCuisine;
import com.restaurant.repositories.MexicanCuisineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Qualifier("mexican")
public class MexicanCuisineServiceImpl implements CuisineService<MexicanCuisine>  {

    @Autowired
    private MexicanCuisineRepository mexicanCuisineRepository;

    @Override
    public Cuisine add(MexicanCuisine cuisine) {
        return mexicanCuisineRepository.save(cuisine);
    }

    @Override
    public List<MexicanCuisine> getAll() {
        return mexicanCuisineRepository.findAll();
    }
}
