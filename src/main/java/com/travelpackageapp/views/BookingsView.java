package com.travelpackageapp.views;

import com.travelpackageapp.dao.BookingDAO;
import com.travelpackageapp.models.Booking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.sql.Date;

public class BookingsView {
    private static BookingDAO bookingDAO = new BookingDAO();

    public static Node getView() {
        TableView<Booking> tableView = new TableView<>();

        TableColumn<Booking, String> packageNameCol = new TableColumn<>("Package Name");
        packageNameCol.setCellValueFactory(new PropertyValueFactory<>("packageName"));

        TableColumn<Booking, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Booking, Integer> membersCol = new TableColumn<>("Members");
        membersCol.setCellValueFactory(new PropertyValueFactory<>("members"));

        TableColumn<Booking, Double> totalCol = new TableColumn<>("Total");
        totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));

        TableColumn<Booking, Date> bookingDateCol = new TableColumn<>("Booking Date");
        bookingDateCol.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));

        tableView.getColumns().addAll(packageNameCol, nameCol, membersCol, totalCol, bookingDateCol);

        ObservableList<Booking> bookings = FXCollections.observableArrayList(bookingDAO.getAllBookings());
        tableView.setItems(bookings);

        // Set styling for TableView
        tableView.setStyle("-fx-background-color: linear-gradient(to bottom, #f7f7f7, #cfcfcf);"
                + "-fx-font-family: Arial;");

        // Header Label
        Label headerLabel = new Label("Booking Details");
        headerLabel.setFont(new Font("Arial", 24));
        headerLabel.setTextFill(Color.web("#2c3e50"));
        headerLabel.setEffect(new DropShadow(5, Color.gray(0.5)));

        HBox headerBox = new HBox(headerLabel);
        headerBox.setBackground(new Background(new BackgroundFill(Color.web("#ecf0f1"), new CornerRadii(5), Insets.EMPTY)));
        headerBox.setPadding(new Insets(10));
        headerBox.setEffect(new DropShadow(10, Color.gray(0.7)));

        // VBox container
        VBox vBox = new VBox(50, headerBox, tableView);
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(20);
        vBox.setBackground(new Background(new BackgroundFill(Color.web("#bdc3c7"), CornerRadii.EMPTY, Insets.EMPTY)));

        return vBox;
    }
}
