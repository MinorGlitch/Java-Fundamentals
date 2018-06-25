package vehiclesExtension;

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
        Bus bus = createBus(reader.readLine().split(" "));

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            execCommand(reader, car, truck, bus);
        }

        printVehicles(car, truck, bus);
    }

    private static Bus createBus(String[] args) {
        return new Bus(Double.valueOf(args[1]), Double.valueOf(args[2]), Double.valueOf(args[3]));
    }

    private static void printVehicles(Vehicle car, Vehicle truck, Vehicle bus) {
        System.out.printf("Car: %.2f%n", car.fuelQuantity);
        System.out.printf("Truck: %.2f%n", truck.fuelQuantity);
        System.out.printf("Bus: %.2f%n", bus.fuelQuantity);
    }

    private static void execCommand(BufferedReader reader, Vehicle car, Vehicle truck, Bus bus) throws IOException {
        String[] commands = reader.readLine().split(" ");

        double val = Double.valueOf(commands[2]);

        switch (commands[0]) {
            case "Drive":
                if (commands[1].equals("Car")) {
                    driveCar(car, val);
                } else if (commands[1].equals("Truck")) {
                    driveTruck(truck, val);
                } else {
                    driveWithPeople(bus, val);
                }
                break;
            case "Refuel":
                if (val <= 0) {
                    System.out.println("Fuel must be a positive number");
                    return;
                }
                switch (commands[1]) {
                    case "Car":
                        if (!car.refillVehicle(val)) {
                            System.out.println("Cannot fit fuel in tank");
                        }
                        break;
                    case "Truck":
                        if (!truck.refillVehicle(val)) {
                            System.out.println("Cannot fit fuel in tank");
                        }
                        break;
                    default:
                        if (!bus.refillVehicle(val)) {
                            System.out.println("Cannot fit fuel in tank");
                        }
                        break;
                }
                break;
            default:
                driveBus(bus, val);
                break;
        }
    }

    private static void driveBus(Vehicle bus, double distanceToTravel) {
        if (bus.drive(distanceToTravel)) {
            System.out.printf("Bus travelled %s km%n", df.format(distanceToTravel));
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    private static void driveWithPeople(Bus bus, double distance) {
        if (bus.driveWithPeople(distance)) {
            System.out.printf("Bus travelled %s km%n", df.format(distance));
        } else {
            System.out.println("Bus needs refueling");
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
        return new Truck(Double.valueOf(args[1]), Double.valueOf(args[2]), Double.valueOf(args[3]));
    }

    private static Car createCar(String[] args) {
        return new Car(Double.valueOf(args[1]), Double.valueOf(args[2]), Double.valueOf(args[3]));
    }
}
