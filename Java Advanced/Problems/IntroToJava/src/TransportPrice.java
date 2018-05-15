import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distance = Integer.parseInt(scanner.nextLine());

        String typeOfDay = scanner.nextLine();

        double totalCost = 0.0D;
        double tariff;

        if (distance >= 20 && distance < 100) {
            tariff = 0.09D;
        } else if (distance >= 100) {
            tariff = 0.06D;
        } else {
            double initialTax = 0.7D;

            totalCost += initialTax;

            if (typeOfDay.equals("day")) {
                tariff = 0.79D;
            } else {
                tariff = 0.9D;
            }
        }

        totalCost += distance * tariff;

        System.out.printf("%.2f", totalCost);
    }
}
