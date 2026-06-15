import java.io.FileWriter;
import java.io.IOException;

public class OrderRepository {
    private final String filePath;

    public OrderRepository(String filePath) {
        this.filePath = filePath;
    }

    public void save(OrderResult result) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("U:" + result.getRequest().getUserName()
                    + " P:" + result.getRequest().getProductId()
                    + " T:" + result.getTotalAmount() + System.lineSeparator());
        }
    }
}
