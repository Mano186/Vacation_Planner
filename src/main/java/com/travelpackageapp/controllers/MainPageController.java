package com.travelpackageapp.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import com.travelpackageapp.views.LoginView;
import com.travelpackageapp.views.SignupView;

public class MainPageController {
    private Stage primaryStage;

    public MainPageController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void handleLoginButtonClick() {
        LoginView loginView = new LoginView(primaryStage);
        Scene loginScene = new Scene(loginView.getView(), 300, 200);
        Stage loginStage = new Stage();
        loginStage.setTitle("Login");
        loginStage.setScene(loginScene);
        loginStage.show();
    }

    public void handleSignupButtonClick() {
        SignupView signupView = new SignupView();
        Scene signupScene = new Scene(signupView.getView(), 800, 600);
        primaryStage.setScene(signupScene);
        primaryStage.show();
    }
}
