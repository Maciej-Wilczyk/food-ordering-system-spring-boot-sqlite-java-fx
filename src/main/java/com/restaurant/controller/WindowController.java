package com.restaurant.controller;

import com.restaurant.cuisines.Cuisine;
import com.restaurant.cuisines.ItalianCuisine;
import com.restaurant.cuisines.MexicanCuisine;
import com.restaurant.cuisines.PolishCuisine;
import com.restaurant.drinks.Drink;
import com.restaurant.order.Order;
import com.restaurant.repositories.CuisineRepository;
import com.restaurant.repositories.ItalianCuisineRepository;
import com.restaurant.repositories.MexicanCuisineRepository;
import com.restaurant.repositories.PolishCuisineRepository;
import com.restaurant.services.*;
import com.restaurant.tableModel.LunchTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.*;

@Component
@FxmlView("/fxml/window.fxml")

public class WindowController implements Initializable {


    @Autowired
    @Qualifier("polish")
    private CuisineService<PolishCuisine> polishCuisineService;

    @Autowired
    @Qualifier("mexican")
    private CuisineService<MexicanCuisine> mexicanCuisineService;
    @Autowired
    @Qualifier("italian")
    private CuisineService<ItalianCuisine> italianCuisineService;

    @Autowired
    private DrinkService drinkService;

    @FXML
    private TableView<LunchTableModel> lunchTable;

    @FXML
    private TableView<Drink> drinkTable;

    @FXML
    private TableView<Order> orderTable;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TableColumn<LunchTableModel, String> mainCurse;

    @FXML
    private TableColumn<LunchTableModel, String> dessert;

    @FXML
    private TableColumn<LunchTableModel, Double> lunchPrice;

    ObservableList<LunchTableModel> lunchData;
    ;


    public void foo() {
//        PolishCuisine cuisine = new PolishCuisine();
//        cuisine.setId(0);
//        cuisine.setMainCurse("Pork Chop");
//        cuisine.setDessert("Apple Pie");
//        cuisine.setPrice(25);
//        polish.save(cuisine);
//        cuisine = new PolishCuisine();
//        cuisine.setId(1);
//        cuisine.setMainCurse("Dumplings");
//        cuisine.setDessert("Cheese Cake");
//        cuisine.setPrice(20);
//        polish.save(cuisine);
//        cuisine = new PolishCuisine();
//        cuisine.setId(2);
//        cuisine.setMainCurse("Cabbage Stew");
//        cuisine.setDessert("Poppy Seed Cake");
//        cuisine.setPrice(15);
//        polish.save(cuisine);
//
//        MexicanCuisine cuisine1 = new MexicanCuisine();
//        cuisine1.setId(3);
//        cuisine1.setMainCurse("Quesadilla");
//        cuisine1.setDessert("Lime Pie");
//        cuisine1.setPrice(17);
//        mexican.save(cuisine1);
//        cuisine1 = new MexicanCuisine();
//        cuisine1.setId(4);
//        cuisine1.setMainCurse("Tortilli'a");
//        cuisine1.setDessert("Tres Leches");
//        cuisine1.setPrice(12);
//        mexican.save(cuisine1);
//        cuisine1 = new MexicanCuisine();
//        cuisine1.setId(5);
//        cuisine1.setMainCurse("Burrito");
//        cuisine1.setDessert("Natilla de nuez");
//        cuisine1.setPrice(45);
//        mexican.save(cuisine1);
////
//        ItalianCuisine cuisine2 = new ItalianCuisine();
//        cuisine2.setId(6);
//        cuisine2.setMainCurse("Pizza");
//        cuisine2.setDessert("Tiramisu");
//        cuisine2.setPrice(30);
//        italian.save(cuisine2);
//        cuisine2 = new ItalianCuisine();
//        cuisine2.setId(7);
//        cuisine2.setMainCurse("Caprese");
//        cuisine2.setDessert("Panna Cotta");
//        cuisine2.setPrice(9);
//        italian.save(cuisine2);
//        cuisine2 = new ItalianCuisine();
//        cuisine2.setId(8);
//        cuisine2.setMainCurse("Spaghetti");
//        cuisine2.setDessert("Granita");
//        cuisine2.setPrice(50);
//        italian.save(cuisine2);

        var list = italianCuisineService.getAll();
        System.out.println(list.get(0).getMainCurse());
    }



    public void setLunchData() {
        var choice = choiceBox.getValue();
        lunchData  = FXCollections.observableArrayList();
        switch (choice) {
            case "Polish":
                for (Cuisine i : polishCuisineService.getAll()) {
                    lunchData.add(new LunchTableModel(i.getMainCurse(), i.getDessert(), i.getPrice()));
                }
                lunchTable.setItems(lunchData);
                lunchTable.refresh();
                break;

            case "Mexican":
                for (Cuisine i : mexicanCuisineService.getAll()) {
                    lunchData.add(new LunchTableModel(i.getMainCurse(), i.getDessert(), i.getPrice()));
                }
                lunchTable.setItems(lunchData);
                lunchTable.refresh();
                break;

            case "Italian":
                for (Cuisine i : italianCuisineService.getAll()) {
                    lunchData.add(new LunchTableModel(i.getMainCurse(), i.getDessert(), i.getPrice()));
                }
                lunchTable.setItems(lunchData);
                lunchTable.refresh();
                break;
        }
    }

    private void setLunchColumns(){
        mainCurse.setCellValueFactory(new PropertyValueFactory<>("mainCurse"));
        dessert.setCellValueFactory(new PropertyValueFactory<>("dessert"));
        lunchPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setValue("Polish");
        setLunchColumns();

    }
}
