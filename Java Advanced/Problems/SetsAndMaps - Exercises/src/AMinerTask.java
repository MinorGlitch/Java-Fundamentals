import java.util.*;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        String mineral = null;
        long quantity;

        Map<String, Long> minerals = new HashMap<>();

        int lineCount = 0;

        while (true) {
            line = scanner.nextLine();

            if (line.equals("stop")) {
                printMinerals(minerals);
                break;
            }

            if (lineCount++ % 2 != 0) {
                quantity = Integer.parseInt(line);

                if (!minerals.containsKey(mineral)) {
                    minerals.put(mineral, quantity);
                } else {
                    minerals.put(mineral, minerals.get(mineral) + quantity);
                }
            } else {
                mineral = line;
            }
        }
    }

    private static void printMinerals(Map<String, Long> minerals) {
        for (Map.Entry<String, Long> mineralEntry : minerals.entrySet()) {
            System.out.printf("%s -> %d%n", mineralEntry.getKey(), mineralEntry.getValue());
        }
    }
}
