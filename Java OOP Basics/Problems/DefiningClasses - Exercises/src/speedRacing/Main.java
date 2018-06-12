package speedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] carArgs = reader.readLine().split(" ");
            String carName = carArgs[0];
            int fuelAmount = Integer.valueOf(carArgs[1]);
            double fuelPerKilometer = Double.valueOf(carArgs[2]);

            cars.putIfAbsent(carName, new Car(carName, fuelAmount, fuelPerKilometer));
        }

        String line = reader.readLine();

        while (!"End".equals(line)) {

        }
    }
}
