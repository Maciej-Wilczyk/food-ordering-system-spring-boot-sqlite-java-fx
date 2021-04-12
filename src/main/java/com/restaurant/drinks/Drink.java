package com.restaurant.drinks;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class Drink {
    @Id
    private long id;
    private String drink;
    private double price;

}
