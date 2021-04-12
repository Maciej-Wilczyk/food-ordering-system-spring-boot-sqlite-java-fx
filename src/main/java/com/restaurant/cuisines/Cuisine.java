package com.restaurant.cuisines;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;


@Entity
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public class Cuisine  {
    @Id
    private long id;
    private String mainCurse;
    private String dessert;
    private double price;
}