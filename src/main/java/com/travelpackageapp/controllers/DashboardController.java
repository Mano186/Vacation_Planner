package com.travelpackageapp.controllers;

import com.travelpackageapp.models.Booking;
import com.travelpackageapp.dao.BookingDAO;
import com.travelpackageapp.views.BookingsView;
import com.travelpackageapp.views.PackagesView;
import com.travelpackageapp.views.ActivitiesView;
import com.travelpackageapp.views.PaymentsView;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class DashboardController {
    private BookingDAO bookingDAO;
    private Stage primaryStage;

    public DashboardController() {
        this.bookingDAO = new BookingDAO(); // Initialize the BookingDAO
    }

    public void handlePackagesButtonClick(VBox mainContent) {
        PackagesView packagesView = new PackagesView();
        mainContent.getChildren().clear();
        mainContent.getChildren().add(packagesView.getView(primaryStage));
    }

    public void handleBookingsButtonClick(VBox mainContent) {
        BookingsView bookingsView = new BookingsView();
        mainContent.getChildren().clear(); // Clear existing content
        mainContent.getChildren().add(BookingsView.getView()); // Add the view returned by getView() method
    }


    public void handleActivitiesButtonClick(VBox mainContent) {

    }

    public void handlePaymentsButtonClick(VBox mainContent) {

    }




}
