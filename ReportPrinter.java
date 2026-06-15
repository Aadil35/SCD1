public class ReportPrinter {
    public void printOrderReport(OrderResult result) {
        OrderRequest request = result.getRequest();

        System.out.println("----- ORDER REPORT -----");
        System.out.println("User: " + request.getUserName());
        System.out.println("Product: " + request.getProductId());
        System.out.println("Quantity: " + result.getFinalQuantity());
        System.out.println("Total: " + result.getTotalAmount());
        System.out.println("Date: " + request.getOrderDate());
    }

    public void printOrderSummary(OrderResult result) {
        System.out.println("----- ORDER SUMMARY -----");
        System.out.println("User: " + result.getRequest().getUserName());
        System.out.println("Total: " + result.getTotalAmount());
    }
}
