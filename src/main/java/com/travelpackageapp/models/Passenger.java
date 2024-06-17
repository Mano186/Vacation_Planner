package com.travelpackageapp.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Passenger {
    private String name;
    private int passengerNumber;
    private List<Activity> signedUpActivities;

    public Passenger(String name, int passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.signedUpActivities = new ArrayList<>();
    }

    public abstract boolean signUpForActivity(Activity activity);

    public void addActivity(Activity activity) {
        signedUpActivities.add(activity);
    }

    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }
}
