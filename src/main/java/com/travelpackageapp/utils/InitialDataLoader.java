package com.travelpackageapp.utils;

import com.travelpackageapp.models.*;

public class InitialDataLoader {
    public static void loadInitialData() {
        // Create some destinations
        Destination paris = new Destination("Paris");
        Destination london = new Destination("London");

        // Create some activities
        Activity eiffelTour = new Activity("Eiffel Tower Tour", "A tour of the Eiffel Tower", 50.0, 30, paris);
        Activity louvreMuseum = new Activity("Louvre Museum", "A visit to the Louvre Museum", 30.0, 20, paris);
        Activity londonEye = new Activity("London Eye", "A ride on the London Eye", 40.0, 25, london);
        Activity britishMuseum = new Activity("British Museum", "A visit to the British Museum", 20.0, 15, london);

        // Add activities to destinations
        paris.addActivity(eiffelTour);
        paris.addActivity(louvreMuseum);
        london.addActivity(londonEye);
        london.addActivity(britishMuseum);

        // Add destinations to travel package
        TravelPackage.addDestination(paris);
        TravelPackage.addDestination(london);
    }
}
