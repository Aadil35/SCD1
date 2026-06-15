public enum PaymentType {
    CASH("Cash payment"),
    CARD("Card payment"),
    BANK("Bank payment"),
    OTHER("Other payment");

    private final String paymentMessage;

    PaymentType(String paymentMessage) {
        this.paymentMessage = paymentMessage;
    }

    public String getPaymentMessage() {
        return paymentMessage;
    }

    public static PaymentType fromText(String value) {
        if (value == null) {
            return OTHER;
        }

        try {
            return PaymentType.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return OTHER;
        }
    }
}
