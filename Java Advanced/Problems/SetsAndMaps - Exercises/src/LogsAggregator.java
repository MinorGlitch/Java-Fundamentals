import java.util.*;

public class LogsAggregator {
    private static Map<String, Map<String, Integer>> log = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] logLine = scanner.nextLine().split(" ");
            String ip = logLine[0];
            String name = logLine[1];
            int duration = Integer.parseInt(logLine[2]);

            log.putIfAbsent(name, new TreeMap<>());
            log.get(name).putIfAbsent(ip, 0);

            log.get(name).put(ip, log.get(name).get(ip) + duration);
        }

        for (Map.Entry<String, Map<String, Integer>> logEntry : log.entrySet()) {
            int totalDuration = logEntry.getValue().values().stream().mapToInt(Integer::valueOf).sum();

            System.out.printf("%s: %d [%s]%n", logEntry.getKey(), totalDuration, String.join(", ", logEntry.getValue().keySet()));
        }

        System.out.println();
    }
}
