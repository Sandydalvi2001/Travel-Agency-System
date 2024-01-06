import java.util.ArrayList;
import enums.PassengerType;
import models.Activity;
import models.Destination;
import models.Passenger;

public class TravelAgencySystem {
    public static void main(String[] args) {
        // Create activities
        Activity activity1 = new Activity("Sightseeing", "Guided tour of the city", 50.0, 10);
        Activity activity2 = new Activity("Hiking", "Explore scenic trails", 30.0, 15);

        // Create destinations
        Destination destination1 = new Destination("City A");
        destination1.addActivity(activity1);
        destination1.addActivity(activity2);

        // Create travel package
        TravelPackage travelPackage = new TravelPackage("Adventure Package", 20,new ArrayList<>(), new ArrayList<>());
        travelPackage.addDestination(destination1);

        // Create passengers
        Passenger passenger1 = new Passenger("John Doe", 1, 1000.0, PassengerType.STANDARD, new ArrayList<>());
        Passenger passenger2 = new Passenger("Jane Doe", 2, 500.0, PassengerType.GOLD, new ArrayList<>());

        // Enroll passengers
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        // Display itinerary
        System.out.println(travelPackage.printItinerary());

        // Display passenger list
        System.out.println(travelPackage.printPassengerList());

        // Display individual passenger details
        System.out.println(travelPackage.printPassengerDetails(passenger1));

        // Display available activities
        System.out.println(travelPackage.printAvailableActivities());
    }
}