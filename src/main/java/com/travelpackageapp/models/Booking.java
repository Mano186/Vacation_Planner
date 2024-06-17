package com.travelpackageapp.models;

import javafx.beans.property.*;

import java.sql.Date;

public class Booking {
    private final StringProperty packageName;
    private final StringProperty name;
    private final IntegerProperty members;
    private final DoubleProperty total;
    private final ObjectProperty<Date> bookingDate;

    public Booking(String packageName, String name, int members, double total, Date bookingDate) {
        this.packageName = new SimpleStringProperty(packageName);
        this.name = new SimpleStringProperty(name);
        this.members = new SimpleIntegerProperty(members);
        this.total = new SimpleDoubleProperty(total);
        this.bookingDate = new SimpleObjectProperty<>(bookingDate);
    }

    // Getter methods
    public String getPackageName() {
        return packageName.get();
    }

    public String getName() {
        return name.get();
    }

    public int getMembers() {
        return members.get();
    }

    public double getTotal() {
        return total.get();
    }

    public Date getBookingDate() {
        return bookingDate.get();
    }

    // Property methods for JavaFX
    public StringProperty packageNameProperty() {
        return packageName;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public IntegerProperty membersProperty() {
        return members;
    }

    public DoubleProperty totalProperty() {
        return total;
    }

    public ObjectProperty<Date> bookingDateProperty() {
        return bookingDate;
    }
}
