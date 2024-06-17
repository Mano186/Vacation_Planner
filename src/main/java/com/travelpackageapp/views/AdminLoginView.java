    package com.travelpackageapp.views;

    import com.travelpackageapp.controllers.AdminLoginController;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.PasswordField;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.VBox;
    import javafx.scene.text.Font;
    import javafx.stage.Modality;
    import javafx.stage.Stage;

    public class AdminLoginView {
        private AdminLoginController adminController = new AdminLoginController();
        private Stage primaryStage ;

        public void showAdminLoginDialog(Stage primaryStage) {
            this.primaryStage = primaryStage;
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Admin Login");

            VBox dialogVbox = new VBox(20);
            dialogVbox.setAlignment(Pos.CENTER);
            dialogVbox.setPadding(new Insets(20));

            Label titleLabel = new Label("Admin Login");
            titleLabel.setFont(new Font("Arial", 20));

            TextField usernameField = new TextField();
            usernameField.setPromptText("Username");

            PasswordField passwordField = new PasswordField();
            passwordField.setPromptText("Password");

            Button loginButton = new Button("Login");

            dialogVbox.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton);

            loginButton.setOnAction(event -> {
                if (adminController.handleAdminLogin(usernameField.getText(), passwordField.getText())) {
                    adminController.showAddPackageDialog(primaryStage);
                    dialog.close();
                } else {
                    System.out.println("Invalid admin credentials");
                }
            });

            Scene dialogScene = new Scene(dialogVbox, 300, 200);
            dialog.setScene(dialogScene);
            dialog.show();
        }


    }
