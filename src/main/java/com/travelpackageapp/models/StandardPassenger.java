package com.travelpackageapp.models;

public class StandardPassenger extends Passenger {
    private double balance;

    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance);
        this.balance = balance;
    }

    @Override
    public boolean signUpForActivity(Activity activity) {
        if (balance >= activity.getCost() && activity.signUp()) {
            balance -= activity.getCost();
            addActivity(activity);
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}
