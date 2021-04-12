package com.restaurant.controller;

import com.restaurant.cuisines.Cuisine;
import com.restaurant.cuisines.ItalianCuisine;
import com.restaurant.cuisines.MexicanCuisine;
import com.restaurant.cuisines.PolishCuisine;
import com.restaurant.drinks.Drink;
import com.restaurant.order.Order;
import com.restaurant.services.*;
import com.restaurant.tableModel.DrinkTableModel;
import com.restaurant.tableModel.LunchTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<DrinkTableModel> drinkTable;

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

    @FXML
    private TableColumn<DrinkTableModel, String> drink;

    @FXML
    private TableColumn<DrinkTableModel, Double> drinkPrice;

    @FXML
    private TableColumn<Order, String> mainCurseO;

    @FXML
    private TableColumn<Order, String> dessertO;

    @FXML
    private TableColumn<Order, String> drinkO;

    @FXML
    private TableColumn<Order, Boolean> iceO;

    @FXML
    private TableColumn<Order, Boolean> lemonO;

    @FXML
    private TableColumn<Order, Double> priceO;

    @FXML
    private CheckBox iceCheckBox;

    @FXML
    private CheckBox lemonCheckBox;

    ObservableList<LunchTableModel> lunchData;

    ObservableList<DrinkTableModel> drinkData;

    ObservableList<Order> orderData = FXCollections.observableArrayList();

    private int lastClickedLunch = 10000, lastClickedDrink = 10000, lastClickedOrder = 10000;

    private double totalPrice = 0.;

    public void setLunchData() {
        var choice = choiceBox.getValue();
        lunchData = FXCollections.observableArrayList();
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

    public void setDrinkData() {
        drinkData = FXCollections.observableArrayList();

        for (Drink i : drinkService.getAll()) {
            drinkData.add(new DrinkTableModel(i.getDrink(), i.getPrice()));
        }
        drinkTable.setItems(drinkData);
        drinkTable.refresh();
    }

    private void setLunchColumns() {
        mainCurse.setCellValueFactory(new PropertyValueFactory<>("mainCurse"));
        dessert.setCellValueFactory(new PropertyValueFactory<>("dessert"));
        lunchPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private void setDrinkColumns() {
        drink.setCellValueFactory(new PropertyValueFactory<>("drink"));
        drinkPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private void setOrderColumns() {
        mainCurseO.setCellValueFactory(new PropertyValueFactory<>("mainCurse"));
        dessertO.setCellValueFactory(new PropertyValueFactory<>("dessert"));
        drinkO.setCellValueFactory(new PropertyValueFactory<>("drink"));
        iceO.setCellValueFactory(new PropertyValueFactory<>("ice"));
        lemonO.setCellValueFactory(new PropertyValueFactory<>("lemon"));
        priceO.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private void setColumns() {
        setLunchColumns();
        setDrinkColumns();
        setOrderColumns();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unClick();
        setFocusedStyle();
        choiceBox.setValue("Polish");
        setDrinkData();
        setColumns();

    }

    private void setFocusedStyle() {
        lunchTable.setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: red;");
        drinkTable.setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: red;");
        orderTable.setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: red;");
    }

    private void unClickLunch() {
        lunchTable.setOnMouseClicked(e -> {
            if (lunchTable.getSelectionModel().getFocusedIndex() == lastClickedLunch) {
                lunchTable.getSelectionModel().select(null);
                lastClickedDrink = 10000;
            }
            lastClickedLunch = lunchTable.getSelectionModel().getFocusedIndex();
        });
    }

    private void unClickDrink() {
        drinkTable.setOnMouseClicked(e -> {
            if (drinkTable.getSelectionModel().getFocusedIndex() == lastClickedDrink) {
                drinkTable.getSelectionModel().select(null);
                lastClickedDrink = 10000;
            }
            lastClickedDrink = drinkTable.getSelectionModel().getFocusedIndex();
        });
    }

    private void unClickOrder() {
        orderTable.setOnMouseClicked(e -> {
            if (orderTable.getSelectionModel().getFocusedIndex() == lastClickedOrder) {
                orderTable.getSelectionModel().select(null);
                lastClickedOrder = 10000;
            }
            lastClickedOrder = orderTable.getSelectionModel().getFocusedIndex();
        });
    }

    private void unClick(){
        unClickLunch();
        unClickDrink();
        unClickOrder();
    }

    public void addOrder() {
        String mainCurse, dessert, drink;
        double lunchPrice, drinkPrice;

        if(lunchTable.getSelectionModel().getSelectedItem() == null && drinkTable.getSelectionModel().getSelectedItem() == null){
            return;
        }

        if(lunchTable.getSelectionModel().getSelectedItem() == null){
            mainCurse = "-";
            dessert = "-";
            lunchPrice = 0.;
        }
        else {
            mainCurse = lunchTable.getSelectionModel().getSelectedItem().getMainCurse();
            dessert = lunchTable.getSelectionModel().getSelectedItem().getDessert();
            lunchPrice = lunchTable.getSelectionModel().getSelectedItem().getPrice();
        }

        if(drinkTable.getSelectionModel().getSelectedItem() == null){
            drink = drinkTable.getSelectionModel().getSelectedItem().getDrink();
            drinkPrice = 0.;
        }
        else {
            drink = drinkTable.getSelectionModel().getSelectedItem().getDrink();
            drinkPrice = drinkTable.getSelectionModel().getSelectedItem().getPrice();
        }
        orderData.add(new Order(mainCurse,dessert,drink,lunchPrice + drinkPrice,iceCheckBox.isSelected(),lemonCheckBox.isSelected()));
        orderTable.setItems(orderData);
        orderTable.refresh();
        totalPrice += lunchPrice + drinkPrice;
        lunchTable.getSelectionModel().clearSelection();
        drinkTable.getSelectionModel().clearSelection();
        lastClickedDrink = 10000;
        lastClickedLunch = 10000;
        lastClickedOrder = 10000;
    }

    public void deleteOrder(){
        var selectionItem = orderTable.getSelectionModel().getSelectedItem();
        orderTable.getItems().remove(selectionItem);
        totalPrice -= selectionItem.getPrice();
        orderTable.refresh();
    }

    public void summary(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Summary");
        alert.setHeaderText("Charge: " + totalPrice + "\nDo you want to finish order");
        ButtonType yesB = new ButtonType("Yes");
        ButtonType noB = new ButtonType("No");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(yesB, noB,buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == yesB) {
            orderTable.getItems().clear();
            orderTable.refresh();
        } else if (result.get() == noB) {
            return;
        }
    }
}
