package com.travelpackageapp.controllers;

import com.travelpackageapp.dao.UserDAO;
import javafx.scene.control.Alert;

public class SignupController {
    private UserDAO userDAO = new UserDAO();

    public void handleSignupButtonClick(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return;
        }

        boolean success = userDAO.addUser(username, password);
        if (success) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid");
            alert.setHeaderText(null);
            alert.setContentText("Registered Successfully");  ;
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid");
            alert.setHeaderText(null);
            alert.setContentText("Registered Failed");  ;
            alert.showAndWait();
        }
    }
}
