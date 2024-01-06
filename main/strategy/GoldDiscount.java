package strategy;

public class GoldDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double cost) {
        return cost*0.9;
    }
}
