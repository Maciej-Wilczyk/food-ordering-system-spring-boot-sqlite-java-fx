package com.restaurant;

import com.restaurant.javaFxApplication.JavaFxApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RestaurantApplication {

    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);

    }

}
