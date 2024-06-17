package com.travelpackageapp.controllers;

import com.travelpackageapp.models.Package;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import com.travelpackageapp.views.DashboardView;
import com.travelpackageapp.dao.UserDAO;
import com.travelpackageapp.models.User;

import java.util.jar.Attributes;

public class LoginController {
    private UserDAO userDAO = new UserDAO();

    public void handleLoginButtonClick(String username, String password, Stage loginStage) {
        User user = userDAO.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            DashboardView dashboardView = new DashboardView();
            String LoginnedUSer = String.valueOf(user);
            Stage primaryStage = (Stage) Stage.getWindows().filtered(window -> window.isShowing()).get(0);
            Scene dashboardScene = dashboardView.getView(primaryStage);
            primaryStage.setScene(dashboardScene);
            loginStage.close(); // Close the login window
        } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Invalid");
                alert.setHeaderText(null);
                alert.setContentText("INVALID USERNAME or PASSWORD")  ;
                alert.showAndWait();

        }
    }
}
