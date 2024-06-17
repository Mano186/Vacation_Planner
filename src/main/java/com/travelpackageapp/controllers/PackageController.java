package com.travelpackageapp.controllers;

import com.travelpackageapp.dao.PackageDAO;
import com.travelpackageapp.models.Package;
import com.travelpackageapp.views.BookingFormView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.VBox;

import java.util.List;

public class PackageController {
    private PackageDAO packageDAO;


    public PackageController() {
        this.packageDAO = new PackageDAO();
    }

    public void savePackage(Package pkg) {
        packageDAO.savePackage(pkg);
    }

    public VBox getPackagesView() {
        VBox packagesBox = new VBox();
        packagesBox.setSpacing(10);

        List<Package> packages = packageDAO.getAllPackages();
        for (Package pkg : packages) {
            Label packageLabel = new Label("Name: " + pkg.getName() + ", Destination: " + pkg.getDestination() +
                    ", Activities: " + pkg.getActivities() + ", Description: " + pkg.getDescription());
            packagesBox.getChildren().add(packageLabel);
        }

        return packagesBox;
    }
    public void handleBookButtonClick() {
        BookingFormView bookingFormView = new BookingFormView();
        Stage bookingStage = new Stage();
        Scene bookingScene = new Scene(bookingFormView.getView(), 400, 400);
        bookingStage.setTitle("Booking Form");
        bookingStage.setScene(bookingScene);
        bookingStage.show();
    }


}
