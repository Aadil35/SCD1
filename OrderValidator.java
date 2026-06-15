public class OrderValidator {
    public void validate(OrderRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Order request cannot be null");
        }

        if (request.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (request.getUnitPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
    }
}
