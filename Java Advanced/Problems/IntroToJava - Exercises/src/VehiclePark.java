import java.util.*;

public class VehiclePark {

    private static int sold = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cars = new ArrayList<>();

        Collections.addAll(cars, scanner.nextLine().split("\\s+"));

        String line = scanner.nextLine();

        while (true) {
            if (line.equals("End of customers!")) {
                break;
            }

            String[] carArgs = line.split("\\s+");

            int seats = Integer.parseInt(carArgs[2]);

            String carType = null;

            switch (carArgs[0]) {
                case "Van":
                    carType = "v";
                    break;
                case "Bus":
                    carType = "b";
                    break;
                case "Car":
                    carType = "c";
                    break;
            }

            String carSignature = getSignature(carType, seats);

            if (!sellCar(cars, carSignature, seats)) {
                System.out.println("No");
            }

            line = scanner.nextLine();
        }

        System.out.printf("Vehicles left: %s%n", String.join(", ", cars));
        System.out.printf("Vehicles sold: %d", sold);
    }

    private static boolean sellCar(List<String> cars, String carSignature, int seats) {
        String currentCar = null;

        for (String car : cars) {
            if (car.equals(carSignature)) {
                currentCar = car;

                int carPrice = carSignature.charAt(0) * seats;

                System.out.printf("Yes, sold for %d$%n", carPrice);

                sold++;
                cars.remove(currentCar);
                return true;
            }
        }

        return false;
    }

    private static String getSignature(String carType, int seats) {
        return carType + seats;
    }
}
