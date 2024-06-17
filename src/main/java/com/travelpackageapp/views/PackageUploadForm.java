package com.travelpackageapp.views;

import com.travelpackageapp.controllers.PackageController;
import com.travelpackageapp.models.Package;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PackageUploadForm {
    private PackageController packageController = new PackageController();

    public void showPackageUploadForm() {
        Stage formStage = new Stage();
        formStage.setTitle("Add Package");

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Label titleLabel = new Label("Add Package");
        titleLabel.setFont(new javafx.scene.text.Font("Arial", 20));

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
            packageController.savePackage(pkg);
            formStage.close(); // Close the form after saving the package
        });

        Scene formScene = new Scene(vbox, 400, 400);
        formStage.setScene(formScene);
        formStage.show();
    }
}
