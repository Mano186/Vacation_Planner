package com.travelpackageapp.views;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import com.travelpackageapp.controllers.SignupController;

public class SignupView {
    private SignupController controller = new SignupController();

    public VBox getView() {
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        // Signup Form
        Label titleLabel = new Label("Sign Up");
        titleLabel.setFont(new Font("Arial", 24));

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setPadding(new Insets(10));

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setPadding(new Insets(10));

        Button signupButton = new Button("Sign Up");
        signupButton.setPadding(new Insets(10, 20, 10, 20));

        vbox.getChildren().addAll(titleLabel, usernameField, passwordField, signupButton);

        // Button action
        signupButton.setOnAction(event -> controller.handleSignupButtonClick(usernameField.getText(), passwordField.getText()));

        return vbox;
    }
}
