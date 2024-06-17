package com.travelpackageapp.views;

import com.travelpackageapp.controllers.AdminLoginController;
import com.travelpackageapp.models.Package;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AddPackageView {
    private AdminLoginController adminLoginController;

    public AddPackageView(AdminLoginController adminLoginController) {
        this.adminLoginController = adminLoginController;
    }

    public VBox getView() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Label titleLabel = new Label("Add Package");
        titleLabel.setFont(new Font("Arial", 20));

        TextField nameField = new TextField();
        nameField.setPromptText("Package Name");

        TextField destinationField = new TextField();
        destinationField.setPromptText("Destination");

        TextField activitiesField = new TextField();
        activitiesField.setPromptText("Activities");

        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Description");

        Button addButton = new Button("Add Package");

        vbox.getChildren().addAll(titleLabel, nameField, destinationField, activitiesField, descriptionField, addButton);

        addButton.setOnAction(event -> {
            Package pkg = new Package(nameField.getText(), destinationField.getText(), activitiesField.getText(), descriptionField.getText());
            adminLoginController.handlePackageAddition(pkg);
        });

        return vbox;
    }
}
