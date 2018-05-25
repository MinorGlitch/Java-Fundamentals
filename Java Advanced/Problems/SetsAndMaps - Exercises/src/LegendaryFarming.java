import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    private static Map<String, Integer> items = new TreeMap<>();
    private static Map<String, Integer> junkItems = new TreeMap<>();
    private static String legendary = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        items.put("fragments", 0);
        items.put("motes", 0);
        items.put("shards", 0);

        while (legendary.equals("")) {
            String[] line = scanner.nextLine().split(" ");

            parseItems(line);

        }
    }

    private static void parseItems(String[] line) {
        for (int i = 1; i < line.length; i += 2) {
             int quantity = Integer.parseInt(line[i - 1]);
             String item = line[i].toLowerCase();

             if (item.equals("shards")) {
                 items.put(item, items.get(item) + quantity);
             } else if (item.equals("motes")) {
                 items.put(item, items.get(item) + quantity);
             } else if (item.equals("fragments")) {
                 items.put(item, items.get(item) + quantity);
             } else {
                 junkItems.putIfAbsent(item, 0);
                 junkItems.put(item, junkItems.get(item) + quantity);
             }

             if (enoughForLegendary(item)) {
                printItems();
                break;
             }
        }
    }

    private static void printItems() {
        items = items.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));


        System.out.printf("%s obtained!%n", legendary);

        for (Map.Entry<String, Integer> itemSet : items.entrySet()) {
            System.out.printf("%s: %d%n", itemSet.getKey(), itemSet.getValue());
        }
        for (Map.Entry<String, Integer> itemSet : junkItems.entrySet()) {
            System.out.printf("%s: %d%n", itemSet.getKey(), itemSet.getValue());
        }
    }

    private static boolean enoughForLegendary(String item) {
        try {
            if (items.get(item) >= 250) {
                items.put(item, items.get(item) - 250);
                if (item.equals("shards")) {
                    legendary = "Shadowmourne";
                } else if (item.equals("fragments")) {
                    legendary = "Valanyr";
                } else if (item.equals("motes")) {
                    legendary = "Dragonwrath";
                }
                return true;
            }
        } catch (NullPointerException ex) {
            return false;
        }

        return false;
    }
}
