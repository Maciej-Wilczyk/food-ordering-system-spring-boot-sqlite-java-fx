package com.restaurant;

import com.restaurant.model.Cuisine;
import com.restaurant.model.PolishCuisine;
import com.restaurant.service.CuisineService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

import static javafx.application.Application.launch;


@SpringBootApplication
public class RestaurantApplication {

    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);

    }

}
