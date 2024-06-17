package com.travelpackageapp.models;

public class GoldPassenger extends Passenger {

    // Constructor and other attributes

    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }

    // Other methods

    public boolean signUpForActivity(Activity activity) {
        double discountedCost = activity.getCost() * 0.9;
        double balance=0;
        if ( balance >= discountedCost && activity.signUp()) {
            balance -= discountedCost;
            addActivity(activity);
            return true;
        }
        return false;
    }

    private double getBalance() {
        return 0;
    }
}
