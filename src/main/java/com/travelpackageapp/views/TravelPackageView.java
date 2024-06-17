package com.travelpackageapp.views;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TravelPackageView {

    private static ObservableList<String> travelPackages = FXCollections.observableArrayList();

    public static VBox getView() {
        VBox vbox = new VBox();

        Label title = new Label("Travel Packages");
        ListView<String> travelPackagesList = new ListView<>(travelPackages);
        // Populate the list with travel packages
        travelPackages.addAll("Package 1", "Package 2", "Package 3"); // Example data

        vbox.getChildren().addAll(title, travelPackagesList);
        return vbox;
    }

    public static void addTravelPackage(String travelPackage) {
        travelPackages.add(travelPackage);
    }
}
