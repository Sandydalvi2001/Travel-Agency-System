package test.models;

import models.Activity;
import models.Destination;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DestinationTest {

    private Destination destination;

    @Before
    public void setUp() {
        destination = new Destination("City A");
    }

    @Test
    public void testAddActivity() {
        // Test adding multiple activities to a destination
        Activity activity1 = new Activity("Sightseeing", "Guided tour of the city", 50.0, 10);
        Activity activity2 = new Activity("Hiking", "Explore scenic trails", 30.0, 15);

        destination.addActivity(activity1);
        destination.addActivity(activity2);

        assertEquals(2, destination.getActivities().size());
    }
}