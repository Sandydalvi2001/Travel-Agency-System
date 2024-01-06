package strategy;

public class PremiumDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double cost) {
        return 0;
    }
}
