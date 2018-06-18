package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> buyers = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] people = reader.readLine().split(";");
        String[] productArgs = reader.readLine().split(";");

        try {
            parseBuyers(people, buyers);
            parseProducts(productArgs, products);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String line = reader.readLine();

        while (!"END".equals(line)) {
            String[] buyerArgs = line.split(" ");
            String buyer = buyerArgs[0];

            if (buyers.get(buyer) != null) {
                Person person = buyers.get(buyer);
                Product product = products.get(buyerArgs[1]);

                try {
                    person.buyProduct(product);
                    System.out.printf("%s bought %s%n", person.getName(), product.getName());
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            line = reader.readLine();
        }

        buyers.values().forEach(b -> {
            System.out.println(b.toString());
        });
    }

    private static void parseProducts(String[] productArgs, Map<String, Product> products) {
        for (String product : productArgs) {
            String[] productArg = product.split("=");
            products.putIfAbsent(productArg[0], new Product(productArg[0], Double.valueOf(productArg[1])));
        }
    }

    private static void parseBuyers(String[] people, Map<String, Person> buyers) {
        for (String person : people) {
            String[] personArgs = person.split("=");
            buyers.putIfAbsent(personArgs[0], new Person(personArgs[0], Double.valueOf(personArgs[1])));
        }
    }
}
