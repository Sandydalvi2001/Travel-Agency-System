package models;

import java.util.List;
import enums.PassengerType;
import strategy.DiscountStrategy;
import strategy.GoldDiscount;
import strategy.PremiumDiscount;
import strategy.StandardDiscount;

public class Passenger {
    
    private String name;
    private int number;
    private double balance;
    private PassengerType type;
    private List<Activity> signedUpActivities;
    private DiscountStrategy discountStrategy;
    
    public Passenger(String name, int number,double balance, PassengerType type, List<Activity> signActivities)
    {
        this.name=name;
        this.number=number;
        this.balance=balance;
        this.type=type;
        this.signedUpActivities=signActivities;
        setDiscountStrategy(type);
    }

    public void setDiscountStrategy(PassengerType type)
    {
        switch (type) {
            case GOLD:
                discountStrategy = new GoldDiscount();
                break;
            case PREMIUM:
                discountStrategy = new PremiumDiscount();
                break;
            default:
                discountStrategy = new StandardDiscount();
                break;
        }
    }

    public void signUpForActivity(Activity activity) {
        if (activity.getCapacity() > 0 && balance >= activity.getCost()) {
            signedUpActivities.add(activity);
            activity.reduceCapacity();
            discountStrategy.applyDiscount(activity.getCost());
        }
    }

    public String getDetails() {
        return String.format("Name: %s, Number: %d, Type: %s, Balance: %.2f", name, number, type, balance);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public PassengerType getType() {
        return type;
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

}
