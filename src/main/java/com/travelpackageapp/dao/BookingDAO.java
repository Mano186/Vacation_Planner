package com.travelpackageapp.dao;

import com.travelpackageapp.models.Package;
import com.travelpackageapp.models.Booking;
import com.travelpackageapp.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT packageName, name, members, Total, bookingDate FROM bookinginfo";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String packageName = resultSet.getString("packageName");
                    String name = resultSet.getString("name");
                    int members = resultSet.getInt("members");
                    double total = resultSet.getDouble("Total");
                    Date bookingDate = resultSet.getDate("bookingDate");

                    Booking booking = new Booking(packageName, name, members, total, bookingDate);
                    bookings.add(booking);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }


    public void saveBooking(Package selectedPackage, String name, String email, String phone, int members, int men, int women, int children, double price, double total, Date bookingDate) {
        String query = "INSERT INTO bookingInfo (packageName, name, email, phone, members, men, women, children, price, Total, bookingDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, selectedPackage.getName());
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setInt(5, members);
            stmt.setInt(6, men);
            stmt.setInt(7, women);
            stmt.setInt(8, children);
            stmt.setDouble(9, price);
            stmt.setDouble(10, total);
            stmt.setDate(11, bookingDate);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getPriceForPackage(String name, String packageMode) {
        String column = switch (packageMode) {
            case "Standard" -> "STANDARD";
            case "Gold" -> "GOLD";
            case "Premium" -> "PREMIUM";
            default -> throw new IllegalArgumentException("Invalid package mode: " + packageMode);
        };

        String query = "SELECT " + column + " FROM package WHERE name = ?";
        double price = 0;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                price = rs.getDouble(column);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;
    }

    public void saveBooking(Booking booking) {
        // Method body for saving booking information
    }
}
