public class OrderResult {
    private final OrderRequest request;
    private final int finalQuantity;
    private final double totalAmount;
    private final PaymentType paymentType;

    public OrderResult(OrderRequest request, int finalQuantity, double totalAmount, PaymentType paymentType) {
        this.request = request;
        this.finalQuantity = finalQuantity;
        this.totalAmount = totalAmount;
        this.paymentType = paymentType;
    }

    public OrderRequest getRequest() {
        return request;
    }

    public int getFinalQuantity() {
        return finalQuantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
