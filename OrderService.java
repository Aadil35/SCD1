import java.io.IOException;

public class OrderService {
    private final UserType userType;
    private final PaymentType paymentType;
    private final OrderValidator orderValidator;
    private final OrderCalculator orderCalculator;
    private final OrderRepository orderRepository;
    private final LogService logService;
    private final ReportPrinter reportPrinter;

    public OrderService(UserType userType, PaymentType paymentType,
                        OrderValidator orderValidator, OrderCalculator orderCalculator,
                        OrderRepository orderRepository, LogService logService,
                        ReportPrinter reportPrinter) {
        this.userType = userType;
        this.paymentType = paymentType;
        this.orderValidator = orderValidator;
        this.orderCalculator = orderCalculator;
        this.orderRepository = orderRepository;
        this.logService = logService;
        this.reportPrinter = reportPrinter;
    }

    public OrderResult processOrder(OrderRequest request) {
        System.out.println("Processing order...");
        orderValidator.validate(request);

        logService.recordStart(request.getUserName());

        int finalQuantity = orderCalculator.calculateFinalQuantity(request);
        double total = orderCalculator.calculateTotal(request, userType);
        OrderResult result = new OrderResult(request, finalQuantity, total, paymentType);

        saveOrder(result);
        System.out.println(paymentType.getPaymentMessage());
        reportPrinter.printOrderReport(result);
        reportPrinter.printOrderSummary(result);

        logService.recordEnd(request.getUserName());
        return result;
    }

    private void saveOrder(OrderResult result) {
        try {
            orderRepository.save(result);
        } catch (IOException ex) {
            System.out.println("Write error");
        }
    }
}
