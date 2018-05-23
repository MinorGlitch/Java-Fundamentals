import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PoisonousPlant {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int plantsCount = Integer.parseInt(reader.readLine());

        String[] stringPlants = reader.readLine().split("\\s+");

        int[] plants  = new int[plantsCount];

        for (int i = 0; i < stringPlants.length; i++) {
            int stringPlant = Integer.parseInt(stringPlants[i]);
            plants[i] = stringPlant;
        }

        int[] daysPlantsDie = new int[plantsCount];

        Deque<Integer> previousPlants = new ArrayDeque<>();

        previousPlants.push(0);

        for (int i = 1; i < plantsCount; i++) {

            int lastDay = 0;

            while (!previousPlants.isEmpty() && plants[previousPlants.peek()] >= plants[i]) {
                lastDay = Math.max(lastDay, daysPlantsDie[previousPlants.pop()]);
            }

            if (!previousPlants.isEmpty()) {
                daysPlantsDie[i] = lastDay + 1;
            }

            previousPlants.push(i);
        }

        int max = -1;

        for (int day : daysPlantsDie) {
            if (day > max) {
                max = day;
            }
        }

        System.out.println(max);
    }
}