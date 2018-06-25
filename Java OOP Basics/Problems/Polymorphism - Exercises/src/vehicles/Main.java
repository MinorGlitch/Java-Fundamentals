package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    private static DecimalFormat df = new DecimalFormat("0.##");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Vehicle car = createCar(reader.readLine().split(" "));
        Vehicle truck = createTruck(reader.readLine().split(" "));

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            execCommand(reader, car, truck);
        }

        printVehicles(car, truck);
    }

    private static void printVehicles(Vehicle car, Vehicle truck) {
        System.out.printf("Car: %.2f%n", car.fuelQuantity);
        System.out.printf("Truck: %.2f%n", truck.fuelQuantity);
    }

    private static void execCommand(BufferedReader reader, Vehicle car, Vehicle truck) throws IOException {
        String[] commands = reader.readLine().split(" ");

        double val = Double.valueOf(commands[2]);

        if (commands[0].equals("Drive")) {
            if (commands[1].equals("Car")) {
                driveCar(car, val);
            } else {
                driveTruck(truck, val);
            }
        } else {
            if (commands[1].equals("Car")) {
                car.refillVehicle(val);
            } else {
                truck.refillVehicle(val);
            }
        }
    }

    private static void driveTruck(Vehicle truck, double distanceToTravel) {
        if (truck.drive(distanceToTravel)) {
            System.out.printf("Truck travelled %s km%n", df.format(distanceToTravel));
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    private static void driveCar(Vehicle car, double distanceToTravel) {
        if (car.drive(distanceToTravel)) {
            System.out.printf("Car travelled %s km%n", df.format(distanceToTravel));
        } else {
            System.out.println("Car needs refueling");
        }
    }


    private static Vehicle createTruck(String[] args) {
        return new Truck(Double.valueOf(args[1]), Double.valueOf(args[2]));
    }

    private static Car createCar(String[] args) {
        return new Car(Double.valueOf(args[1]), Double.valueOf(args[2]));
    }
}
