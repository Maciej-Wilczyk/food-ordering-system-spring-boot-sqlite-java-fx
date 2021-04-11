package com.restaurant.model;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.Entity;

@Entity
@Qualifier("polish")
public class PolishCuisine extends Cuisine {
}
