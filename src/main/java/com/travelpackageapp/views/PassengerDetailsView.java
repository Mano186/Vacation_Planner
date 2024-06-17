package com.travelpackageapp.views;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import com.travelpackageapp.models.Passenger;
import com.travelpackageapp.models.StandardPassenger;
import com.travelpackageapp.models.TravelPackage;
import com.travelpackageapp.models.Activity;

public class PassengerDetailsView {

    public static VBox getView() {
        VBox vbox = new VBox();

        Label title = new Label("Passenger Details");
        TextField passengerNumberField = new TextField();
        passengerNumberField.setPromptText("Passenger Number");

        Button viewButton = new Button("View Details");
        viewButton.setOnAction(e -> {
            int passengerNumber = Integer.parseInt(passengerNumberField.getText());
            Passenger passenger = TravelPackage.getPassenger(passengerNumber);
            if (passenger != null) {
                String details = "Passenger details for passenger number " + passengerNumber + "\n";
                details += "Name: " + passenger.getName() + "\n";
                if (passenger instanceof StandardPassenger) {
                    details += "Balance: " + ((StandardPassenger) passenger).getBalance() + "\n";
                }
                // Display activities
                details += "Activities: \n";
                for (Activity activity : passenger.getSignedUpActivities()) {
                    details += "  " + activity.getName() + " at " + activity.getDestination().getName() + " for $" + activity.getCost() + "\n";
                }
                // Display details in an alert
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Passenger Details");
                alert.setHeaderText(null);
                alert.setContentText(details);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Passenger not found!");
                alert.showAndWait();
            }
        });

        vbox.getChildren().addAll(title, passengerNumberField, viewButton);
        return vbox;
    }
}
