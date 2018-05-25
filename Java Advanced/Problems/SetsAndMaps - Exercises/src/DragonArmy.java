import java.util.*;

public class DragonArmy {
    private static Map<String, Map<String, Integer[]>> dragons = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] dragonArgs = scanner.nextLine().split(" ");
            parseDragon(dragonArgs);
        }

        printDragons();
    }

    private static void printDragons() {
        for (Map.Entry<String, Map<String, Integer[]>> typeSet : dragons.entrySet()) {
            double averageDamage = getAverageDamage(typeSet.getValue());
            double averageHealth = getAverageHealth(typeSet.getValue());
            double averageArmor = getAverageArmor(typeSet.getValue());

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",
                    typeSet.getKey(), averageDamage, averageHealth, averageArmor);

            for (Map.Entry<String, Integer[]> dragon : typeSet.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %s%n",
                        dragon.getKey(), dragon.getValue()[0], dragon.getValue()[1], dragon.getValue()[2]);
            }
        }
    }

    private static double getAverageArmor(Map<String, Integer[]> dragons) {
        int count = dragons.size();

        long sum = 0L;

        for (Integer[] stats : dragons.values()) {
            sum += stats[2];
        }

        return (double) sum / (double) count;
    }

    private static double getAverageHealth(Map<String, Integer[]> dragons) {
        int count = dragons.size();

        long sum = 0L;

        for (Integer[] stats : dragons.values()) {
            sum += stats[1];
        }

        return (double) sum / (double) count;
    }

    private static double getAverageDamage(Map<String, Integer[]> dragons) {
        int count = dragons.size();

        long sum = 0L;

        for (Integer[] stats : dragons.values()) {
            sum += stats[0];
        }

        return (double) sum / (double) count;
    }

    private static void parseDragon(String[] dragonArgs) {
        String type = dragonArgs[0];
        String name = dragonArgs[1];

        int damage;

        try {
            damage = Integer.parseInt(dragonArgs[2]);
        } catch (NumberFormatException ex) {
            damage = 45;
        }

        int health;

        try {
            health = Integer.parseInt(dragonArgs[3]);
        } catch (NumberFormatException ex) {
            health = 250;
        }

        int armor;

        try {
            armor = Integer.parseInt(dragonArgs[4]);
        } catch (NumberFormatException ex) {
            armor = 10;
        }

        dragons.putIfAbsent(type, new TreeMap<>());
        dragons.get(type).putIfAbsent(name, new Integer[]{45, 250, 10});

        dragons.get(type).get(name)[0] = damage;
        dragons.get(type).get(name)[1] = health;
        dragons.get(type).get(name)[2] = armor;
    }
}
