package foodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Buyer> individuals = new LinkedHashMap<>();


        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] individualArgs = reader.readLine().split(" ");

            if (individualArgs[0] == null || individualArgs[0].isEmpty()) {
                continue;
            }

            individuals.putIfAbsent(individualArgs[0], createIndividual(individualArgs));
        }

        String line = reader.readLine();

        while (!"End".equals(line)) {
            if (individuals.get(line) != null) {
                individuals.get(line).buyFood();
            }

            line = reader.readLine();
        }

        System.out.println(individuals.values().stream().mapToInt(Buyer::getFood).sum());
    }

    private static Buyer createIndividual(String[] individualArgs) {
        int length = individualArgs.length;

        switch (length) {
            case 4:
                return new Citizen(individualArgs[0], Integer.valueOf(individualArgs[1]),
                        individualArgs[2], individualArgs[3]);
            case 3:
                return new Rebel(individualArgs[0], Integer.valueOf(individualArgs[1]), individualArgs[2]);
            default:
                return null;
        }
    }


}
