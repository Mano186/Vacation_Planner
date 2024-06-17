package com.travelpackageapp.models;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private int enrolledCount;
    private Destination destination;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.enrolledCount = 0;
        this.destination = destination;
    }

    public boolean signUp() {
        if (enrolledCount < capacity) {
            enrolledCount++;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledCount() {
        return enrolledCount;
    }

    public int getAvailableSpaces() {
        return capacity - enrolledCount;
    }

    public Destination getDestination() {
        return destination;
    }

    public boolean hasAvailableSpace() {
        return true;
    }
}
