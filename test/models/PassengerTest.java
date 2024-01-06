package test.models;

import enums.PassengerType;
import models.Activity;
import models.Passenger;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class PassengerTest {

    @Test
    void testStandardPassenger() {
        Passenger passenger = new Passenger("John Doe", 1, 1000.0, PassengerType.STANDARD, new ArrayList<>());
        assertEquals("John Doe", passenger.getName());
        assertEquals(1, passenger.getNumber());
        assertEquals(PassengerType.STANDARD, passenger.getType());
        assertEquals(1000.0, passenger.getBalance());
    }

    @Test
    void testGoldPassenger() {
        Passenger passenger = new Passenger("Jane Doe", 2, 500.0, PassengerType.PREMIUM, new ArrayList<>());
        assertEquals("Jane Doe", passenger.getName());
        assertEquals(2, passenger.getNumber());
        assertEquals(PassengerType.PREMIUM, passenger.getType());
        assertEquals(500.0, passenger.getBalance());
    }

    @Test
    void testPremiumPassenger() {
        Passenger passenger = new Passenger("Bob Smith", 3,  0.0, PassengerType.GOLD, new ArrayList<>());
        assertEquals("Bob Smith", passenger.getName());
        assertEquals(3, passenger.getNumber());
        assertEquals(PassengerType.GOLD, passenger.getType());
        assertEquals(0.0, passenger.getBalance());
    }

    @Test
    void testPassengerActivityEnrollment() {
        Passenger passenger = new Passenger("Alice Johnson", 4, 100.0, PassengerType.STANDARD, new ArrayList<>());
        assertEquals(0, passenger.getSignedUpActivities().size());

        // Assume you have a method like enrollActivity in the Passenger class
        Activity activity = new Activity("Sightseeing", "Guided tour of the city", 50.0, 10);
        passenger.signUpForActivity(activity);

        assertEquals(1, passenger.getSignedUpActivities().size());
    }

    @Test
    public void testSignUpForActivity() {
        List<Activity> signedUpActivities = new ArrayList<>();
        Passenger passenger = new Passenger("John Doe", 1, 1000.0, PassengerType.STANDARD, signedUpActivities);
        // Test signing up for multiple activities
        Activity activity1 = new Activity("Sightseeing", "Guided tour of the city", 50.0, 10);
        Activity activity2 = new Activity("Hiking", "Explore scenic trails", 30.0, 15);

        passenger.signUpForActivity(activity1);
        passenger.signUpForActivity(activity2);

        assertEquals(2, passenger.getSignedUpActivities().size());
    }

    @Test
    public void testSetDiscountStrategy() {
        List<Activity> signedUpActivities = new ArrayList<>();
        Passenger passenger = new Passenger("John Doe", 1, 1000.0, PassengerType.STANDARD, signedUpActivities);
        // Test setting discount strategy for different passenger types
        passenger.setDiscountStrategy(PassengerType.GOLD);
        assertEquals(90.0, passenger.getDiscountStrategy().applyDiscount(100.0));

        Passenger premiumPassenger = new Passenger("Jane Doe", 2, 500.0, PassengerType.PREMIUM, new ArrayList<>());
        premiumPassenger.setDiscountStrategy(PassengerType.PREMIUM);
        assertEquals(0.0, premiumPassenger.getDiscountStrategy().applyDiscount(100.0), 0.001);
    }
}

