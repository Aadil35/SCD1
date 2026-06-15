import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogService {
    private final List<String> logs = new ArrayList<>();

    public void recordStart(String userName) {
        logs.add("Start:" + userName);
    }

    public void recordEnd(String userName) {
        logs.add("End:" + userName);
    }

    public List<String> getLogs() {
        return Collections.unmodifiableList(logs);
    }

    public void exportLogs(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String log : logs) {
                writer.write(log + System.lineSeparator());
            }
        }
    }
}
