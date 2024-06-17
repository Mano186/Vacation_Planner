package com.travelpackageapp.models;

public class Package {
    private int packageId;
    private String name;
    private String destination;
    private String activities;
    private String description;

    // Constructors
    public Package() {}



    public Package(int packageId, String name, String destination, String activities, String description) {
        this.packageId = packageId;
        this.name = name;
        this.destination = destination;
        this.activities = activities;
        this.description = description;
    }

    public Package(String text, String text1, String text2, String text3) {
    }

    // Getters and setters
    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
