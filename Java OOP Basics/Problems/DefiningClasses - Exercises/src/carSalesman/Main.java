package carSalesman;

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

        Map<String, Engine> engines = new LinkedHashMap<>();

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            Engine engine = createEngine(reader.readLine().split(" "));

            engines.putIfAbsent(engine.getModel(), engine);
        }

        n = Integer.valueOf(reader.readLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Car car = createCar(reader.readLine().split(" "), engines);
            cars.add(car);
        }

        cars.forEach(System.out::println);
    }

    private static Car createCar(String[] carArgs, Map<String, Engine> engines) {
        String model = carArgs[0];
        String engineModel = carArgs[1];

        Engine engine = engines.get(engineModel);

        int weight;
        String color;

        if (carArgs.length == 4) {
            String thirdArg = carArgs[2];
            String fourthArg = carArgs[3];

            if (isNumber(thirdArg)) {
                weight = Integer.valueOf(thirdArg);
                color = fourthArg;
            } else {
                weight = Integer.valueOf(fourthArg);
                color = thirdArg;
            }

            return new Car(model, engine, weight, color);
        } else if (carArgs.length == 3) {
            String thirdArg = carArgs[2];

            if (isNumber(thirdArg)) {
                weight = Integer.valueOf(thirdArg);
                return new Car(model, engine, weight);
            } else {
                return new Car(model, engine, thirdArg);
            }
        }

        return new Car(model, engine);
    }

    private static Engine createEngine(String[] engineArgs) {
        String model = engineArgs[0];
        int power = Integer.valueOf(engineArgs[1]);

        int displacement;
        String efficiency;

        if (engineArgs.length == 4) {
            String thirdArg = engineArgs[2];
            String fourthArg = engineArgs[3];

            if (isNumber(thirdArg)) {
                displacement = Integer.valueOf(thirdArg);
                efficiency = fourthArg;
            } else {
                efficiency = thirdArg;
                displacement = Integer.valueOf(fourthArg);
            }

            return new Engine(model, power, displacement, efficiency);
        } else if (engineArgs.length == 3) {
            String thirdArg = engineArgs[2];
            if (isNumber(thirdArg)) {
                displacement = Integer.valueOf(thirdArg);
                return new Engine(model, power, displacement);
            } else {
                return new Engine(model, power, thirdArg);
            }
        }

        return new Engine(model, power);
    }

    private static boolean isNumber(String thirdArg) {
        try {
            Integer.parseInt(thirdArg);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
