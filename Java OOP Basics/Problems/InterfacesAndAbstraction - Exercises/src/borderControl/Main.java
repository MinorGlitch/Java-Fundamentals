package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        List<Individual> individuals = new ArrayList<>();

        while (!"End".equals(line)) {
            String[] lineArgs = line.split(" ");

            if (lineArgs.length == 3) {
                individuals.add(new Citizen(lineArgs[0], Integer.valueOf(lineArgs[1]), lineArgs[2]));
            } else if (lineArgs.length == 2) {
                individuals.add(new Robot(lineArgs[0], lineArgs[1]));
            }

            line = reader.readLine();
        }

        String idSignature = reader.readLine();

        individuals.stream().filter(i -> i.getId().endsWith(idSignature)).forEach(i -> System.out.println(i.getId()));
    }
}
