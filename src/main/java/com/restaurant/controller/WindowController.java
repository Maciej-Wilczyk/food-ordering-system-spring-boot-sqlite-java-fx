package com.restaurant.controller;

import com.restaurant.model.PolishCuisine;
import com.restaurant.service.CuisineService;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/fxml/window.fxml")
@RequiredArgsConstructor
public class WindowController {


    @Qualifier("polish")
    final CuisineService cuisineService;



    public void foo(){
        PolishCuisine polishCuisine1 = new PolishCuisine();
        polishCuisine1.setId(0);
        polishCuisine1.setMeal("kotlet");
        polishCuisine1.setDrink("picie");
        polishCuisine1.setIce(false);
        polishCuisine1.setLemon(true);
        cuisineService.add(polishCuisine1);

        polishCuisine1 = new PolishCuisine();
        polishCuisine1.setId(1);
        polishCuisine1.setMeal("lkl");
        polishCuisine1.setDrink("yggy");
        polishCuisine1.setIce(false);
        polishCuisine1.setLemon(true);
        cuisineService.add(polishCuisine1);
        var list = cuisineService.getAll();
        System.out.println(list);
    }
}
