package com.travelpackageapp.controllers;

import com.travelpackageapp.dao.AdminLoginDAO;
import com.travelpackageapp.views.AddPackageView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class AdminLoginController {
    private AdminLoginDAO adminLoginDAO;

    public AdminLoginController() {
        this.adminLoginDAO = new AdminLoginDAO();
    }

    public boolean handleAdminLogin(String username, String password) {
        return adminLoginDAO.login(username, password);
    }
    public void showAddPackageDialog(Stage primaryStage) {

        Stage stage = new Stage(); // Create a new Stage instance
        AdminLoginController adminLoginController = new AdminLoginController();
        AddPackageView addPackageView = new AddPackageView(adminLoginController);

        Scene addPackageScene = new Scene(addPackageView.getView(), 400, 400);
        stage.setScene(addPackageScene);
        stage.show();
    }
    public void handlePackageAddition(com.travelpackageapp.models.Package pkg) {
        // Logic to add the package to the database
        // Assuming the package was successfully added
        showSuccessMessage();
    }

    private void showSuccessMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Package added successfully!");
        alert.showAndWait();


    }
}
