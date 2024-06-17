package com.travelpackageapp.dao;

import com.travelpackageapp.models.Package;
import com.travelpackageapp.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PackageDAO {
    private Connection connection = DatabaseConnection.getConnection();

    public PackageDAO() {
        if (connection == null) {
            throw new IllegalStateException("Database connection is null");
        }
    }


    public void savePackage(Package pkg) {
        // SQL query to insert package into the database
        String sql = "INSERT INTO Package (name, destination, activities, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pkg.getName());
            statement.setString(2, pkg.getDestination());
            statement.setString(3, pkg.getActivities());
            statement.setString(4, pkg.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Package> getAllPackages() {
        List<Package> packages = new ArrayList<>();
        // SQL query to retrieve all packages from the database
        String sql = "SELECT * FROM Package";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int packageId = resultSet.getInt("package_id");
                String name = resultSet.getString("name");
                String destination = resultSet.getString("destination");
                String activities = resultSet.getString("activities");
                String description = resultSet.getString("description");
                Package pkg = new Package(packageId, name, destination, activities, description);
                packages.add(pkg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packages;
    }
}
