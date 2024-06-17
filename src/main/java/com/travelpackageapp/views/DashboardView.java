package com.travelpackageapp.views;

import com.travelpackageapp.dao.UserDAO;
import com.travelpackageapp.models.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import com.travelpackageapp.controllers.DashboardController;

public class DashboardView {
    private DashboardController controller = new DashboardController();
    private String username;

    public DashboardView() {
        this.username = username;
    }

    public Scene getView(Stage primaryStage) {
        HBox hbox = new HBox();
        hbox.setSpacing(20);
        hbox.setAlignment(Pos.CENTER_LEFT);

        // Sidebar
        VBox sidebar = new VBox();
        sidebar.setSpacing(10);
        sidebar.setAlignment(Pos.TOP_LEFT);
        sidebar.setStyle("-fx-background-color: #2c3e50; -fx-padding: 10px;");

        Button packagesButton = new Button("Packages");
        Button bookingsButton = new Button("Bookings");
        Button activitiesButton = new Button("Activities");
        Button paymentsButton = new Button("Payments");

        String sidebarButtonStyle = "-fx-background-color: #34495e; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-font-size: 14px; -fx-border-radius: 5px; -fx-background-radius: 5px;";
        String sidebarButtonHoverStyle = "-fx-background-color: #1abc9c;-fx-text-fill: white; -fx-padding: 10px 20px; -fx-font-size: 14px; -fx-border-radius: 5px; -fx-background-radius: 5px;";

        packagesButton.setStyle(sidebarButtonStyle);
        packagesButton.setOnMouseEntered(e -> packagesButton.setStyle(sidebarButtonHoverStyle));
        packagesButton.setOnMouseExited(e -> packagesButton.setStyle(sidebarButtonStyle));

        bookingsButton.setStyle(sidebarButtonStyle);
        bookingsButton.setOnMouseEntered(e -> bookingsButton.setStyle(sidebarButtonHoverStyle));
        bookingsButton.setOnMouseExited(e -> bookingsButton.setStyle(sidebarButtonStyle));

        activitiesButton.setStyle(sidebarButtonStyle);
        activitiesButton.setOnMouseEntered(e -> activitiesButton.setStyle(sidebarButtonHoverStyle));
        activitiesButton.setOnMouseExited(e -> activitiesButton.setStyle(sidebarButtonStyle));

        paymentsButton.setStyle(sidebarButtonStyle);
        paymentsButton.setOnMouseEntered(e -> paymentsButton.setStyle(sidebarButtonHoverStyle));
        paymentsButton.setOnMouseExited(e -> paymentsButton.setStyle(sidebarButtonStyle));

        sidebar.getChildren().addAll(packagesButton, bookingsButton, activitiesButton, paymentsButton);

        // Main content
        VBox mainContent = new VBox();
        mainContent.setSpacing(10);
        mainContent.setAlignment(Pos.CENTER);
        mainContent.setStyle("-fx-padding: 20px;");

        Label dashboardLabel = new Label("Dashboard");
        dashboardLabel.setFont(new Font("Arial", 24));
        dashboardLabel.setStyle("-fx-text-fill: #34495e;");

        // Display the logged-in user's name
        Label userLabel = new Label("Logged in as: " + username);
        userLabel.setFont(new Font("Arial", 18));
        userLabel.setStyle("-fx-text-fill: #34495e;");

        mainContent.getChildren().addAll(dashboardLabel, userLabel);

        hbox.getChildren().addAll(sidebar, mainContent);

        // Button actions
        packagesButton.setOnAction(event -> controller.handlePackagesButtonClick(mainContent));
        bookingsButton.setOnAction(event -> controller.handleBookingsButtonClick(mainContent));
        activitiesButton.setOnAction(event -> controller.handleActivitiesButtonClick(mainContent));
        paymentsButton.setOnAction(event -> controller.handlePaymentsButtonClick(mainContent));

        Scene scene = new Scene(hbox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("VacationBook Dashboard");
        primaryStage.show();

        return scene;
    }
}
