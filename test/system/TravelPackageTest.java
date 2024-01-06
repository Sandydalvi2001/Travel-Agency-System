package test.system;

import models.Activity;
import models.Destination;
import models.Passenger;
import system.TravelPackage;
import org.junit.Before;
import org.junit.Test;

import enums.PassengerType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TravelPackageTest {

    private TravelPackage travelPackage;

    @Before
    public void setUp() {
        List<Destination> itinerary = new ArrayList<>();
        List<Passenger> passengers = new ArrayList<>();
        travelPackage = new TravelPackage("Adventure Package", 20, itinerary, passengers);
    }

    @Test
    public void testConstructor() {
        assertEquals("Adventure Package", travelPackage.getName());
        assertEquals(20, travelPackage.getCapacity());
        assertEquals(0, travelPackage.getItinerary().size());
        assertEquals(0, travelPackage.getPassengers().size());
    }

    @Test
    public void testAddDestination() {
        Destination destination = new Destination("City A");
        travelPackage.addDestination(destination);
        assertEquals(1, travelPackage.getItinerary().size());
    }

    @Test
    public void testAddPassenger() {
        Passenger passenger = new Passenger("John Doe", 1, 1000.0, PassengerType.STANDARD, new ArrayList<>());
        travelPackage.addPassenger(passenger);
        assertEquals(1, travelPackage.getPassengers().size());
    }
}
