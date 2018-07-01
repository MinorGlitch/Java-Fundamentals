package mooD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //"KoHaH" | Demon | 100.0 | 100

        BaseCharacter character = createCharacter(reader.readLine().split("\\s+\\|\\s+"));

        System.out.println(character);
    }

    private static BaseCharacter createCharacter(String... args) {
        String name = args[0];
        String type = args[1];
        double points = Double.valueOf(args[2]);
        int level = Integer.valueOf(args[3]);

        if (type.equals("Demon")) {
            return new Demon(name, type, level, points);
        }

        return new Archangel(name, type, level, points);
    }
}
