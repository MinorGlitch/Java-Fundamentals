import java.util.*;
import java.util.Scanner;

public class UserLogs {

    private static Map<String, Map<String, Integer>> log = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] lineArgs = line.split(" ");

            String ip = lineArgs[0].split("=")[1];
            String user = lineArgs[2].split("=")[1];

            log.putIfAbsent(user, new LinkedHashMap<>());

            if (!log.get(user).containsKey(ip)) {
                log.get(user).put(ip, 0);
            }

            log.get(user).put(ip, log.get(user).get(ip) + 1);

            line = scanner.nextLine();
        }

        printLog();
    }

    private static void printLog() {
        for (Map.Entry<String, Map<String, Integer>> logEntry : log.entrySet()) {
            System.out.println(logEntry.getKey() + ":");
            int count = logEntry.getValue().size();
            for (Map.Entry<String, Integer> ipEntry : logEntry.getValue().entrySet()) {
                if (count-- > 1) {
                    System.out.printf("%s => %d, ", ipEntry.getKey(), ipEntry.getValue());
                } else {
                    System.out.printf("%s => %d.%n", ipEntry.getKey(), ipEntry.getValue());
                }
            }
        }
    }
}
