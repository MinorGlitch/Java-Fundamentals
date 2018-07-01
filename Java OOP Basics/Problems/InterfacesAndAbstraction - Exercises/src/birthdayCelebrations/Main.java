package birthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Individual> individuals = new ArrayList<>();

        String line = reader.readLine();

        while (!"End".equals(line)) {
            String[] individualArgs = line.split(" ");

            Individual individual = createIndividual(individualArgs);

            if (individual != null) {
                individuals.add(individual);
            }

            line = reader.readLine();
        }

        String year = reader.readLine();

        individuals.stream()
                .filter(i -> i.getBirthYear()
                        .equals(year))
                .forEach(i -> System.out.println(i.getBirthDate()));
    }

    private static Individual createIndividual(String[] individualArgs) {
        String type = individualArgs[0];


        switch (type) {
            case "Citizen":
                return new Citizen(individualArgs[1], Integer.valueOf(individualArgs[2]),
                        individualArgs[3], individualArgs[4]);
            case "Pet":
                return new Pet(individualArgs[1], individualArgs[2]);
            default:
                return null;
        }
    }


}
