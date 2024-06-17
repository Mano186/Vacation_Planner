package com.travelpackageapp.views;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import com.travelpackageapp.models.Passenger;
import com.travelpackageapp.models.StandardPassenger;
import com.travelpackageapp.models.TravelPackage;

public class AddPassengerView {

    public static VBox getView() {
        VBox vbox = new VBox();

        Label title = new Label("Add Passenger");
        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField passengerNumberField = new TextField();
        passengerNumberField.setPromptText("Passenger Number");

        TextField balanceField = new TextField();
        balanceField.setPromptText("Balance");

        Button addButton = new Button("Add Passenger");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            int passengerNumber = Integer.parseInt(passengerNumberField.getText());
            double balance = Double.parseDouble(balanceField.getText());
            Passenger passenger = new StandardPassenger(name, passengerNumber, balance);
            // Add passenger to the travel package
            TravelPackage.addPassenger(passenger);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Passenger Added");
            alert.setHeaderText(null);
            alert.setContentText("Passenger " + name + " added successfully!");
            alert.showAndWait();
        });

        vbox.getChildren().addAll(title, nameField, passengerNumberField, balanceField, addButton);
        return vbox;
    }
}
