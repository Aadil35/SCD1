public enum UserType {
    STANDARD(1, -5.0, 10.0),
    PREMIUM(2, 5.0, 2.0),
    GUEST(3, 0.0, 1.0),
    UNKNOWN(0, 0.0, 0.0);

    private final int code;
    private final double orderAdjustment;
    private final double discountAmount;

    UserType(int code, double orderAdjustment, double discountAmount) {
        this.code = code;
        this.orderAdjustment = orderAdjustment;
        this.discountAmount = discountAmount;
    }

    public int getCode() {
        return code;
    }

    public double getOrderAdjustment() {
        return orderAdjustment;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public static UserType fromCode(int code) {
        for (UserType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
