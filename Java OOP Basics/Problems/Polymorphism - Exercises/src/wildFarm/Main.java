package wildFarm;

import wildFarm.animal.*;
import wildFarm.food.Food;
import wildFarm.food.Meat;
import wildFarm.food.Vegetable;

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

        while (!line.equals("End")) {
            Animal animal = parseAnimal(line.split(" "));
            Food food = parseFood(reader.readLine().split(" "));

            System.out.println(animal.makeSound());

            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animals.add(animal);

            line = reader.readLine();
        }

        animals.forEach(a -> System.out.println(a.toString()));
    }

    private static Food parseFood(String[] foodArgs) {
        String type = foodArgs[0];
        int nutrition = Integer.valueOf(foodArgs[1]);

        switch (type) {
            case "Vegetable":
                return new Vegetable(nutrition);
            case "Meat":
                return new Meat(nutrition);
            default:
                break;
        }

        return null;
    }

    private static Animal parseAnimal(String[] animalArgs) {
        String animal = animalArgs[0];
        String name = animalArgs[1];
        double weight = Double.valueOf(animalArgs[2]);
        String livingRegion = animalArgs[3];

        switch (animal) {
            case "Mouse":
                return new Mouse(name, weight, livingRegion);
            case "Zebra":
                return new Zebra(name, weight, livingRegion);
            case "Cat":
                String breed = animalArgs[4];
                return new Cat(name, weight, livingRegion, breed);
            case "Tiger":
                return new Tiger(name, weight, livingRegion);
            default:
                break;
        }

        return null;
    }
}
