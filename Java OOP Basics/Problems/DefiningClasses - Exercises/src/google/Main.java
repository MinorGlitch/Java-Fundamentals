package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();

        String line = reader.readLine();

        while (!"End".equals(line)) {
            parsePeople(people, line);

            line = reader.readLine();
        }

        String name = reader.readLine();

        System.out.println(people.get(name).toString());

    }

    private static void parsePeople(Map<String, Person> people, String line) {
        String[] personArgs = line.split(" ");

        String personName = personArgs[0];

        people.putIfAbsent(personName, new Person(personName));

        String type = personArgs[1];

        switch (type) {
            case "company":
                String companyName = personArgs[2];
                String department = personArgs[3];
                double salary = Double.valueOf(personArgs[4]);
                people.get(personName).setCompany(new Company(companyName, department, salary));
                break;
            case "pokemon":
                String pokemonName = personArgs[2];
                String pokemonType = personArgs[3];
                people.get(personName).addPokemon(new Pokemon(pokemonName, pokemonType));
                break;
            case "parents":
                String parentName = personArgs[2];
                String parentBirthday = personArgs[3];
                people.get(personName).addParent(new Parent(parentName, parentBirthday));
                break;
            case "children":
                String childName = personArgs[2];
                String childBirthday = personArgs[3];
                people.get(personName).addChild(new Child(childName, childBirthday));
                break;
            case "car" :
                String model = personArgs[2];
                int speed = Integer.valueOf(personArgs[3]);
                people.get(personName).setCar(new Car(model, speed));
                break;
        }
    }
}
