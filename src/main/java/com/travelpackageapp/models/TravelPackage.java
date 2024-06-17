package com.travelpackageapp.models;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private static List<Passenger> passengers = new ArrayList<>();
    private static List<Destination> destinations = new ArrayList<>();

    public static void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public static Passenger getPassenger(int passengerNumber) {
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerNumber() == passengerNumber) {
                return passenger;
            }
        }
        return null;
    }

    public static void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public static List<Destination> getDestinations() {
        return destinations;
    }
}
