package models;

public class Activity
{
    String name;
    String description;
    double cost;
    int capacity;
    
    public Activity(String name, String description, double cost, int capacity)
    {
        this.name=name;
        this.description=description;
        this.cost=cost;
        this.capacity=capacity;
    }
}