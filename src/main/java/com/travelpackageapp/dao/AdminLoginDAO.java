package com.travelpackageapp.dao;

import com.travelpackageapp.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginDAO {
    private Connection connection;

    public AdminLoginDAO() {
        // Initialize the database connection
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean login(String username, String password) {
        String sql = "SELECT * FROM Admin WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // If there is a result, the login is successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
