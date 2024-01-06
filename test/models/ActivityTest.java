package test.models;

import org.junit.jupiter.api.Test;
import models.Activity;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;

class ActivityTest {

    private Activity activity;

    @Test
    public void testReduceCapacity() {
        // Test reducing capacity multiple times
        activity = new Activity("Sightseeing", "Guided tour of the city", 50.0, 10);
        activity.reduceCapacity();
        activity.reduceCapacity();
        assertEquals(8, activity.getCapacity());
    }

    @Test
    void testActivityDetails() {
        activity = new Activity("Sightseeing", "Guided tour of the city", 50.0, 10);
        assertEquals("Sightseeing", activity.getName());
        assertEquals("Guided tour of the city", activity.getDescription());
        assertEquals(50.0, activity.getCost());
        assertEquals(10, activity.getCapacity());
    }
}