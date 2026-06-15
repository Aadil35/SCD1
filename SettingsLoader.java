import java.io.File;
import java.util.Scanner;

public class SettingsLoader {
    private static final String USER_TYPE_PREFIX = "U";
    private static final String PAYMENT_TYPE_PREFIX = "P";

    public Settings load(String filePath) {
        UserType userType = UserType.STANDARD;
        PaymentType paymentType = PaymentType.CASH;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.startsWith(USER_TYPE_PREFIX)) {
                    userType = UserType.fromCode(Integer.parseInt(line.substring(2).trim()));
                } else if (line.startsWith(PAYMENT_TYPE_PREFIX)) {
                    paymentType = PaymentType.fromText(line.substring(2).trim());
                }
            }
        } catch (Exception ex) {
            System.out.println("Settings not loaded. Default settings will be used.");
        }

        return new Settings(userType, paymentType);
    }
}
