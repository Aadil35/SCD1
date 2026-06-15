public class DiscountService {
    public double applyDiscount(UserType userType, double bill) {
        return bill - userType.getDiscountAmount();
    }
}
