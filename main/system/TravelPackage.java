package system;
import java.util.List;
import models.Activity;
import models.Destination;
import models.Passenger;

public class TravelPackage {
    
    private String name;
    private int capacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int capacity, List<Destination> itinerary, List<Passenger> passengers)
    {
        this.name=name;
        this.capacity=capacity;
        this.itinerary=itinerary;
        this.passengers=passengers;
    }

    public void addDestination(Destination destination)
    {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger)
    {
        passengers.add(passenger);
    }

    public String printItinerary() {
        StringBuilder itineraryDetails = new StringBuilder("Travel Package Itinerary:\n");
        itineraryDetails.append("Name: ").append(name).append("\n");

        for (Destination destination : itinerary) {
            itineraryDetails.append("Destination: ").append(destination.getName()).append("\n");

            for (Activity activity : destination.getActivities()) {
                itineraryDetails.append("  Activity: ").append(activity.getName())
                        .append(", Cost: ").append(activity.getCost())
                        .append(", Capacity: ").append(activity.getCapacity())
                        .append(", Description: ").append(activity.getDescription()).append("\n");
            }
        }

        return itineraryDetails.toString();
    }

    public String printPassengerList() {
        StringBuilder passengerListDetails = new StringBuilder("Travel Package Passenger List:\n");
        passengerListDetails.append("Name: ").append(name).append("\n");
        passengerListDetails.append("Capacity: ").append(capacity).append("\n");
        passengerListDetails.append("Passengers Enrolled: ").append(passengers.size()).append("\n");

        for (Passenger passenger : passengers) {
            passengerListDetails.append("  Name: ").append(passenger.getName())
                    .append(", Number: ").append(passenger.getNumber()).append("\n");
        }

        return passengerListDetails.toString();
    }

    public String printAvailableActivities() {
        StringBuilder availableActivitiesDetails = new StringBuilder("Available Activities:\n");

        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getCapacity() > 0) {
                    availableActivitiesDetails.append("Destination: ").append(destination.getName())
                            .append(", Activity: ").append(activity.getName())
                            .append(", Cost: ").append(activity.getCost())
                            .append(", Capacity: ").append(activity.getCapacity())
                            .append(", Description: ").append(activity.getDescription()).append("\n");
                }
            }
        }

        return availableActivitiesDetails.toString();
    }

    public String printPassengerDetails(Passenger passenger) {
        StringBuilder passengerDetails = new StringBuilder("Passenger Details:\n");

        passengerDetails.append(passenger.getDetails()).append("\n");

        if (!passenger.getSignedUpActivities().isEmpty()) {
            passengerDetails.append("Activities Signed Up:\n");

            for (Activity activity : passenger.getSignedUpActivities()) {
                passengerDetails.append("  Destination: ").append(printDestinationName(activity))
                        .append(", Activity: ").append(activity.getName())
                        .append(", Cost: ").append(activity.getCost()).append("\n");
            }
        }

        return passengerDetails.toString();
    }

    private String printDestinationName(Activity activity) {
        for (Destination destination : itinerary) {
            if (destination.getActivities().contains(activity)) {
                return destination.getName();
            }
        }
        return "Unknown";
    }


    public String getName() {
        return name;
    }


    public int getCapacity() {
        return capacity;
    }


    public List<Destination> getItinerary() {
        return itinerary;
    }


    public List<Passenger> getPassengers() {
        return passengers;
    }

    
}
