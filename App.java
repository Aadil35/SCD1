import java.io.IOException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Settings settings = new SettingsLoader().load("settings.conf");

        LogService logService = new LogService();
        OrderService orderService = new OrderService(
                settings.getUserType(),
                settings.getPaymentType(),
                new OrderValidator(),
                new OrderCalculator(),
                new OrderRepository("order_data.txt"),
                logService,
                new ReportPrinter()
        );

        OrderRequest request = new OrderRequest(
                "Ali",
                101,
                2,
                999.99,
                "Karachi",
                true,
                "Handle carefully",
                LocalDate.of(2025, 11, 12)
        );

        orderService.processOrder(request);

        DiscountService discountService = new DiscountService();
        double discountedTotal = discountService.applyDiscount(settings.getUserType(), 5000);
        System.out.println("Discounted total: " + discountedTotal);

        ShippingService shippingService = new ShippingService();
        int shippingCost = shippingService.calculateShippingCost(35);
        System.out.println("Shipping cost: " + shippingCost);

        new UserPrinter().printUser("Ali", 25);

        try {
            logService.exportLogs("logs.txt");
        } catch (IOException ex) {
            System.out.println("Log export error");
        }

        new NotificationService().notifyUser("Ali", "Your order has been processed successfully!");
    }
}
