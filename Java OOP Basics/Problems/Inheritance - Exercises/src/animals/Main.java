package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        List<Animal> animals = new ArrayList<>();

        while (!"Beast!".equals(line)) {
            String animalType = line;

            String[] animalArgs = reader.readLine().split(" ");

            try {
                animals.add(createAnimal(animalArgs, animalType));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            line = reader.readLine();
        }

        animals.forEach(a -> {
            System.out.println(a.toString());
            a.produceSound();
        });
    }

    private static Animal createAnimal(String[] animalArgs, String type) {
        switch (type) {
            case "Dog":
                return new Dog(animalArgs[0], Integer.valueOf(animalArgs[1]), animalArgs[2]);
            case "Cat":
                return new Cat(animalArgs[0], Integer.valueOf(animalArgs[1]), animalArgs[2]);
            case "Frog":
                return new Frog(animalArgs[0], Integer.valueOf(animalArgs[1]), animalArgs[2]);
            case "Kitten":
                return new Kitten(animalArgs[0], Integer.valueOf(animalArgs[1]));
            case "Tomcat":
                return new Tomcat(animalArgs[0], Integer.valueOf(animalArgs[1]));
            default:
                throw new IllegalArgumentException(Animal.INVALID_INPUT_MESSAGE);
        }
    }
}
