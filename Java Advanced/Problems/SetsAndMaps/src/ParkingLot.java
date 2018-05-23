import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carNumbers = new HashSet<>();

        String line;

        while (true) {
            line = scanner.nextLine();

            if (line.equals("END")) {
                break;
            }

            String[] lineArgs = line.split(", ");

            if (lineArgs[0].equals("IN")) {
                carNumbers.add(lineArgs[1]);
            } else {
                carNumbers.remove(lineArgs[1]);
            }
        }

        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
            return;
        }

        carNumbers.forEach(System.out::println);
    }
}
