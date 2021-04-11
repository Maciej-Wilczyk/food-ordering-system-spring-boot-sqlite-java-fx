package com.restaurant.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public class Cuisine {
    @Id
    private long id;
    private String meal;
    private String drink;
    private boolean ice;
    private boolean lemon;
}
