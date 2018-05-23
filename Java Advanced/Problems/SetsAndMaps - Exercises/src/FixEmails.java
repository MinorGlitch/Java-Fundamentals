import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        String email = null;
        String name = scanner.nextLine();

        Map<String, String> emails = new LinkedHashMap<>();

        int lineCount = 0;

        while (!name.equals("stop")) {
            email = scanner.nextLine();

            String domainName = checkDomainName(email);

            if (!(domainName.toLowerCase().equals(".us") ||
                    domainName.toLowerCase().equals(".uk") ||
                    domainName.toLowerCase().equals(".com"))) {

                emails.put(name, email);
            }


            name = scanner.nextLine();
        }

        printEmails(emails);
    }

    private static String checkDomainName(String email) {
        return email.substring(email.indexOf('.'), email.length());
    }

    private static void printEmails(Map<String, String> emails) {
        for (Map.Entry<String, String> emailEntry : emails.entrySet()) {

            System.out.printf("%s -> %s%n", emailEntry.getKey(), emailEntry.getValue());
        }
    }
}
