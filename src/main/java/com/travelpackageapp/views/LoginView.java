package com.travelpackageapp.views;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import com.travelpackageapp.controllers.LoginController;
import javafx.stage.Stage;

public class LoginView {
    private LoginController controller = new LoginController();
    private Stage loginStage;

    // Constructor to initialize the login stage
    public LoginView(Stage loginStage) {
        this.loginStage = loginStage;
    }

    public VBox getView() {
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        // Login Form
        Label titleLabel = new Label("Login");
        titleLabel.setFont(new Font("Arial", 24));

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setPadding(new Insets(10));

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setPadding(new Insets(10));

        Button loginButton = new Button("Login");

        vbox.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton);

        // Button action
        loginButton.setOnAction(event -> controller.handleLoginButtonClick(usernameField.getText(), passwordField.getText(), loginStage));

        return vbox;
    }
}
