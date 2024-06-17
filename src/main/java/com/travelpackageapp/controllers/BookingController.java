package com.travelpackageapp.controllers;

import com.travelpackageapp.dao.BookingDAO;
import com.travelpackageapp.models.Package;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.Date;

public class BookingController {
    public void handleBookButtonClick(String firstName, String lastName, String aadhaar, String mobile, String email, String packageModel) {
        // Implement booking logic here

        // For now, show a success alert
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Booking Successful");
        alert.setHeaderText(null);
        alert.setContentText("Your package has been booked successfully!");
        alert.showAndWait();
    }
    private BookingDAO bookingDAO;

    public BookingController() {
        this.bookingDAO = new BookingDAO();
    }

    public void bookPackage(Package selectedPackage, String name, String email, String phone, int members, int men, int women, int children, double pricePerPerson, double totalAmount, Date bookingDate) {
        bookingDAO.saveBooking(selectedPackage, name, email, phone, members, men, women, children, pricePerPerson, totalAmount,bookingDate);
    }

    public double getPriceForPackage(String packageName, String packageMode) {
        return bookingDAO.getPriceForPackage(packageName, packageMode);
    }

}
