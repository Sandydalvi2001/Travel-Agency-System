package strategy;

public class StandardDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double cost) {
        return cost;
    }
}
