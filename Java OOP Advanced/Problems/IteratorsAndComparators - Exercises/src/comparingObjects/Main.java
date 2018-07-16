package comparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String line = reader.readLine();

        while (!"END".equals(line)) {
            String[] lineArgs = line.split(" ");

            people.add(new Person(lineArgs[0], Integer.valueOf(lineArgs[1]), lineArgs[2]));

            line = reader.readLine();
        }

        Person targetPerson;

        try {
            targetPerson = people.get(Integer.valueOf(reader.readLine()));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("No matches");
            return;
        }

        int equal = (int) people.stream().filter(s -> s.compareTo(targetPerson) == 0).count();
        int different = (int) people.stream().filter(s -> s.compareTo(targetPerson) != 0).count();

        if (equal == 0 ) {
            System.out.println("No matches");
            return;
        }

        System.out.printf("%d %d %d", equal, different, people.size());
    }
}
