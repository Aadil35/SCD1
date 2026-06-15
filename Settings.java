public class Settings {
    private final UserType userType;
    private final PaymentType paymentType;

    public Settings(UserType userType, PaymentType paymentType) {
        this.userType = userType;
        this.paymentType = paymentType;
    }

    public UserType getUserType() {
        return userType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
