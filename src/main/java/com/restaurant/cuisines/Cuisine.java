package com.restaurant.cuisines;

import lombok.Data;
import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public class Cuisine  {
    @Id
    private long id;
    private String mainCurse;
    private String dessert;
    private double price;
}