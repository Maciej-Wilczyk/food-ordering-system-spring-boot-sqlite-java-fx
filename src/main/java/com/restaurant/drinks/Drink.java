package com.restaurant.drinks;

import com.restaurant.cuisines.Cuisine;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Drink {
    @Id
    private long id;
    private String name;
    private double price;

}
