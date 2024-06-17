package com.travelpackageapp.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void testStandardPassengerSignUp() {
        Destination paris = new Destination("Paris");
        Activity eiffelTour = new Activity("Eiffel Tower Tour", "A tour of the Eiffel Tower", 50.0, 30, paris);
        StandardPassenger passenger = new StandardPassenger("John Doe", 1, 100.0);

        assertTrue(passenger.signUpForActivity(eiffelTour));
        assertEquals(50.0, passenger.getBalance());
        assertEquals(1, eiffelTour.getEnrolledCount());
    }

    @Test
    public void testGoldPassengerSignUp() {
        Destination london = new Destination("London");
        Activity londonEye = new Activity("London Eye", "A ride on the London Eye", 40.0, 25, london);
        GoldPassenger passenger = new GoldPassenger("Jane Smith", 2, 100.0);

        assertTrue(passenger.signUpForActivity(londonEye));
        assertEquals(64.0, passenger.getBalance());
        assertEquals(1, londonEye.getEnrolledCount());
    }

    @Test
    public void testPremiumPassengerSignUp() {
        Destination tokyo = new Destination("Tokyo");
        Activity sushiMaking = new Activity("Sushi Making Class", "Learn to make sushi", 75.0, 10, tokyo);
        PremiumPassenger passenger = new PremiumPassenger("Alice Brown", 3);

        assertTrue(passenger.signUpForActivity(sushiMaking));
        assertEquals(10, sushiMaking.getCapacity() - sushiMaking.getEnrolledCount());
    }
}
