package com.travelpackageapp.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import com.travelpackageapp.controllers.MainPageController;

import java.util.Objects;

public class MainPageView {
    private MainPageController controller;

    public MainPageView(Stage primaryStage) {
        this.controller = new MainPageController(primaryStage);
    }

    public VBox getView() {
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setStyle("-fx-background-color: #f0f0f0;");

        // Header
        HBox header = new HBox();
        header.setSpacing(10);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(10, 20, 10, 20));
        header.setStyle("-fx-background-color: #2c3e50; -fx-padding: 10px;");

        Label logoLabel = new Label("VacationBook");
        logoLabel.setFont(new Font("Arial", 24));
        logoLabel.setStyle("-fx-text-fill: #ecf0f1;");

        HBox spacer = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button loginButton = new Button("Login");
        Button signupButton = new Button("Sign Up");
        loginButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: #ecf0f1;");
        signupButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: #ecf0f1;");

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().addAll(loginButton, signupButton);

        header.getChildren().addAll(logoLabel, spacer, buttonBox);

        vbox.getChildren().add(header);

        // Load image
        try {
            String imagePath = "/com/travelpackageapp/assets/main.png";
            System.out.println("Loading image from: " + imagePath);  // Print the image path for debugging

            Image image = new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());
            System.out.println("Image loaded successfully.");  // Print success message

            BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
            BackgroundImage backgroundImage = new BackgroundImage(
                    image,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER, backgroundSize);

            vbox.setBackground(new Background(backgroundImage));
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

        // Button actions
        loginButton.setOnAction(event -> controller.handleLoginButtonClick());
        signupButton.setOnAction(event -> controller.handleSignupButtonClick());

        return vbox;
    }
}
