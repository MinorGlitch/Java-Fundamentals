import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robots = scanner.nextLine().split(";");

        int totalRobots = robots.length;

        String[] robotNames = new String[totalRobots];
        int[] processTimes = new int[totalRobots];
        int[] secondsLeft = new int[totalRobots];

        parseRobots(robots, robotNames, processTimes);

        String[] timeArgs = scanner.nextLine().split(":");

        int hours = Integer.parseInt(timeArgs[0]) * 60 * 60;
        int minutes = Integer.parseInt(timeArgs[1]) * 60;
        int seconds = Integer.parseInt(timeArgs[2]);

        long totalSeconds = hours + minutes + seconds;

        String line = scanner.nextLine();

        Deque<String> products = new ArrayDeque<>();

        while (!line.equals("End")) {
            products.offer(line);
            line = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            totalSeconds++;

            for (int i = 0; i < robots.length; i++) {
                if (secondsLeft[i] > 0) {
                    secondsLeft[i]--;
                }
            }

            boolean productTaken = false;

            String currentProduct = products.poll();

            for (int i = 0; i < robots.length; i++) {
                if (secondsLeft[i] == 0) {
                    System.out.printf("%s - %s [%s]%n", robotNames[i], currentProduct, getCurrentTime(totalSeconds));
                    secondsLeft[i] += processTimes[i];
                    productTaken = true;
                    break;
                }
            }

            if (!productTaken) {
                products.offer(currentProduct);
            }
        }
    }

    private static String getCurrentTime(long seconds) {
        seconds %= 24 * 3600;
        int hours = (int) seconds / 3600;
        seconds %= 3600;
        int minutes = (int) seconds / 60;
        seconds %= 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private static void parseRobots(String[] robots, String[] robotNames, int[] processTimes) {
        for (int i = 0; i < robots.length; i++) {
            String[] robotArgs = robots[i].split("-");

            robotNames[i] = robotArgs[0];
            processTimes[i] = Integer.parseInt(robotArgs[1]);
        }
    }
}
