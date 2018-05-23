import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> regularGuests = new TreeSet<>();
        Set<String> vipGuests = new TreeSet<>();

        String line;

        while (true) {
            line = scanner.nextLine();

            if (line.equals("PARTY")) {
                break;
            }

            if (isVIP(line)) {
                vipGuests.add(line);
            } else {
                regularGuests.add(line);
            }
        }

        while (true) {
            line = scanner.nextLine();

            if (line.equals("END")) {
                break;
            }

            if (vipGuests.contains(line)) {
                vipGuests.remove(line);
            } else {
                regularGuests.remove(line);
            }
        }

        System.out.println(vipGuests.size() + regularGuests.size());

        vipGuests.forEach(System.out::println);
        regularGuests.forEach(System.out::println);
    }

    private static boolean isVIP(String line) {
        char signature = line.charAt(0);

        return Character.isDigit(signature);
    }
}
