package rawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> carTokens = Arrays.asList(reader.readLine().split(" "));

            Tire[] tires = new Tire[4];

            Deque<Double> tireValues = carTokens
                    .subList(5, carTokens.size())
                    .stream()
                    .map(Double::parseDouble)
                    .collect(Collectors.toCollection(ArrayDeque::new));

            for (int j = 0; j < 4; j++) {
                addTireToArray(tireValues, tires, j);
            }

            cars.add(createCar(carTokens, tires));
        }

        String cargoType = reader.readLine();

        cars.stream().filter(c -> {
            if (cargoType.equals("fragile")) {
                return c.getCargo().getType().equals(cargoType) && c.getTires()[0].getPressure() < 1;
            }

            return c.getCargo().getType().equals(cargoType) && c.getEngine().getPower() > 250;
        }).forEach(c -> System.out.println(c.getModel()));
    }

    private static Car createCar(List<String> carTokens, Tire[] tires) {
        int engineSpeed = Integer.valueOf(carTokens.get(1));
        int enginePower = Integer.valueOf(carTokens.get(2));

        Engine engine = new Engine(engineSpeed, enginePower);

        int cargoWeight = Integer.valueOf(carTokens.get(3));

        Cargo cargo = new Cargo(cargoWeight, carTokens.get(4));

        return new Car(carTokens.get(0), engine, cargo, tires);
    }

    private static void addTireToArray(Deque<Double> tireValues, Tire[] tires, int index) {
        double tirePressure = tireValues.pop();
        int tireAge = tireValues.pop().intValue();

        tires[index] = new Tire(tirePressure, tireAge);
    }
}
