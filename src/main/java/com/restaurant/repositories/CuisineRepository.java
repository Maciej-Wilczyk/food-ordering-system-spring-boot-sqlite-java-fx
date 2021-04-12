package com.restaurant.repositories;

import com.restaurant.cuisines.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository<T extends Cuisine> extends JpaRepository<T,Long> {

}
