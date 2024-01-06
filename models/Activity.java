package models;

public class Activity
{
    private String name;
    private String description;
    private double cost;
    private int capacity;

    public Activity(String name, String description, double cost, int capacity)
    {
        this.name=name;
        this.description=description;
        this.cost=cost;
        this.capacity=capacity;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void reduceCapacity() {
        capacity--;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}