import java.util.*;

public class Phonebook {

    private static Map<String, String> phonebook = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;

        while (true) {
            line = scanner.nextLine();

            if (line.equals("search")) {
                break;
            }

            String[] personArgs = line.split("-");

            phonebook.put(personArgs[0], personArgs[1]);
        }

        while (true) {
            line = scanner.nextLine();

            if (line.equals("stop")) {
                break;
            }

            String name = line;

            searchForPerson(name);
        }
    }

    private static void searchForPerson(String name) {
        if (phonebook.containsKey(name)) {
            System.out.printf("%s -> %s%n", name, phonebook.get(name));
        } else {
            System.out.printf("Contact %s does not exist.%n", name);
        }
    }
}
