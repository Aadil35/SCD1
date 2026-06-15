public class OrderCalculator {
    private static final int URGENT_QUANTITY_BONUS = 1;
    private static final double BASE_FEE_A = 10.0;
    private static final double BASE_FEE_B = 20.0;

    public int calculateFinalQuantity(OrderRequest request) {
        if (request.isUrgent()) {
            return request.getQuantity() + URGENT_QUANTITY_BONUS;
        }
        return request.getQuantity();
    }

    public double calculateTotal(OrderRequest request, UserType userType) {
        int finalQuantity = calculateFinalQuantity(request);
        double subtotal = finalQuantity * request.getUnitPrice();
        return subtotal + BASE_FEE_A + BASE_FEE_B + userType.getOrderAdjustment();
    }
}
