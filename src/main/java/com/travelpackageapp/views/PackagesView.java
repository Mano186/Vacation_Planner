package com.travelpackageapp.views;

import com.travelpackageapp.controllers.PackageController;
import com.travelpackageapp.dao.PackageDAO;
import com.travelpackageapp.models.Package;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static com.travelpackageapp.views.BookingFormView.showBookingConfirmation;

public class PackagesView {
    private PackageController packageController = new PackageController();

    public VBox getView(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        // Header
        Label titleLabel = new Label("Available Packages");
        titleLabel.setFont(new Font("Arial", 24));
        titleLabel.setTextFill(Color.BLUE);

        // Display Available Packages
        VBox packageList = new VBox();
        packageList.setSpacing(10);
        packageList.setAlignment(Pos.CENTER_LEFT);

        // Assuming you have established a connection to your database
        // Create an instance of PackageDAO with the connection
        PackageDAO packageDAO = new PackageDAO();

        for (Package packageInfo : packageDAO.getAllPackages()) {
            Label packageNameLabel = new Label("Package Name: " + packageInfo.getName());
            Label destinationLabel = new Label("Destination: " + packageInfo.getDestination());
            Label activitiesLabel = new Label("Activities: " + packageInfo.getActivities());
            Label descriptionLabel = new Label("Description: " + packageInfo.getDescription());

            Button bookButton = new Button("Book Package");
            bookButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px;");
            bookButton.setOnAction(event -> {
                BookingFormView.showBookingForm(packageInfo,primaryStage);

            });

            VBox packageInfoBox = new VBox(packageNameLabel, destinationLabel, activitiesLabel, descriptionLabel, bookButton);
            packageInfoBox.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10px; -fx-border-color: #ccc;");
            packageList.getChildren().add(packageInfoBox);
        }

        // Add Package Button
        Button addPackageButton = new Button("Add Package");
        addPackageButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        addPackageButton.setOnAction(event -> {
            AdminLoginView adminLoginView = new AdminLoginView();
            adminLoginView.showAdminLoginDialog(primaryStage);
        });

        vbox.getChildren().addAll(titleLabel, packageList, addPackageButton);
        vbox.setPadding(new Insets(20));

        return vbox;
    }




}
