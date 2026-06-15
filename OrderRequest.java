import java.time.LocalDate;

public class OrderRequest {
    private final String userName;
    private final int productId;
    private final int quantity;
    private final double unitPrice;
    private final String address;
    private final boolean urgent;
    private final String notes;
    private final LocalDate orderDate;

    public OrderRequest(String userName, int productId, int quantity, double unitPrice,
                        String address, boolean urgent, String notes, LocalDate orderDate) {
        this.userName = userName;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.address = address;
        this.urgent = urgent;
        this.notes = notes;
        this.orderDate = orderDate;
    }

    public String getUserName() {
        return userName;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getAddress() {
        return address;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
