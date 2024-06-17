package com.travelpackageapp.views;

import com.travelpackageapp.controllers.BookingController;
import com.travelpackageapp.models.Package;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Date;

public class BookingFormView {
    private static BookingController bookingController = new BookingController();

    public static void showBookingForm(Package aPackage, Stage primaryStage) {
        Stage dialog = new Stage();
        dialog.setTitle("Booking Form");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label packageLabel = new Label("Package: " + aPackage.getName());
        gridPane.add(packageLabel, 0, 0, 2, 1);

        Label nameLabel = new Label("Name:");
        gridPane.add(nameLabel, 0, 1);
        TextField nameField = new TextField();
        gridPane.add(nameField, 1, 1);

        Label emailLabel = new Label("Email:");
        gridPane.add(emailLabel, 0, 2);
        TextField emailField = new TextField();
        gridPane.add(emailField, 1, 2);

        Label phoneLabel = new Label("Phone:");
        gridPane.add(phoneLabel, 0, 3);
        TextField phoneField = new TextField();
        gridPane.add(phoneField, 1, 3);

        Label memberCountLabel = new Label("Members Count:");
        gridPane.add(memberCountLabel, 0, 4);
        TextField memberCountField = new TextField();
        gridPane.add(memberCountField, 1, 4);

        Label menCountLabel = new Label("Men:");
        gridPane.add(menCountLabel, 0, 5);
        TextField menCountField = new TextField();
        gridPane.add(menCountField, 1, 5);

        Label womenCountLabel = new Label("Women:");
        gridPane.add(womenCountLabel, 0, 6);
        TextField womenCountField = new TextField();
        gridPane.add(womenCountField, 1, 6);

        Label childrenCountLabel = new Label("Children:");
        gridPane.add(childrenCountLabel, 0, 7);
        TextField childrenCountField = new TextField();
        gridPane.add(childrenCountField, 1, 7);

        Label packageModeLabel = new Label("Package Mode:");
        gridPane.add(packageModeLabel, 0, 8);
        ChoiceBox<String> packageModeBox = new ChoiceBox<>();
        packageModeBox.getItems().addAll("Standard", "Gold", "Premium");
        gridPane.add(packageModeBox, 1, 8);

        Label priceLabel = new Label("Price per Person:");
        gridPane.add(priceLabel, 0, 9);
        TextField priceField = new TextField();
        priceField.setEditable(false);
        gridPane.add(priceField, 1, 9);

        Label totalAmountLabel = new Label("Total Amount:");
        gridPane.add(totalAmountLabel, 0, 10);
        TextField totalAmountField = new TextField();
        totalAmountField.setEditable(false);
        gridPane.add(totalAmountField, 1, 10);

        Label dateLabel = new Label("Booking Date :");
        gridPane.add(dateLabel, 0, 11);
        DatePicker datePicker = new DatePicker();
        gridPane.add(datePicker, 1, 11);

        Button bookButton = new Button("Book");
        gridPane.add(bookButton, 0, 12, 2, 1);

        packageModeBox.setOnAction(event -> {
            String selectedMode = packageModeBox.getValue();
            double price = bookingController.getPriceForPackage(aPackage.getName(), selectedMode);
            priceField.setText(String.valueOf(price));

            // Automatically calculate the total amount
            try {
                int members = Integer.parseInt(memberCountField.getText().trim());
                double totalAmount = members * price;
                totalAmountField.setText(String.valueOf(totalAmount));
            } catch (NumberFormatException e) {
                totalAmountField.setText("0");
            }
        });

        bookButton.setOnAction(event -> {
            try {
                int members = Integer.parseInt(memberCountField.getText().trim());
                int men = Integer.parseInt(menCountField.getText().trim());
                int women = Integer.parseInt(womenCountField.getText().trim());
                int children = Integer.parseInt(childrenCountField.getText().trim());
                double pricePerPerson = Double.parseDouble(priceField.getText());
                double totalAmount = Double.parseDouble(totalAmountField.getText());

                // Get the booking date
                Date bookingDate = Date.valueOf(datePicker.getValue());

                bookingController.bookPackage(aPackage, nameField.getText(), emailField.getText(), phoneField.getText(),
                        members, men, women, children, pricePerPerson, totalAmount, bookingDate);
                showBookingConfirmation(aPackage);
                dialog.close();
            } catch (NumberFormatException e) {
                // Optionally show an error message to the user
            }
        });

        Scene dialogScene = new Scene(gridPane, 400, 600);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public Parent getView() {
        return null;
    }

    static void showBookingConfirmation(Package packageInfo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Booking Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("You have successfully booked the package: " + packageInfo.getName());
        alert.showAndWait();
    }
}
