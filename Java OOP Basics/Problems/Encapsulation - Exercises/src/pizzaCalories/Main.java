package pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String INVALID_TOPPINGS_COUNT_MESSAGE = "Number of toppings should be in range [0..10].";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pizza pizza;
        try {
            pizza = createPizza(reader);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        for (int i = 0; i < pizza.getToppingsCount(); i++) {
            String[] toppingArgs = reader.readLine().split(" ");
            String toppingName = toppingArgs[1];
            double toppingWeight = Double.valueOf(toppingArgs[2]);

            try {
                Topping topping = new Topping(toppingName, toppingWeight);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getTotalPizzaCalories());
    }

    private static Pizza createPizza(BufferedReader reader) throws IOException {
        String[] pizzaArgs = reader.readLine().split(" ");

        String name = pizzaArgs[1];
        int numberOfToppings = Integer.valueOf(pizzaArgs[2]);

        String[] doughArgs = reader.readLine().split(" ");

        String doughType = doughArgs[1];
        String bakeType = doughArgs[2];
        double weight = Double.valueOf(doughArgs[3]);

        if (!isValidNumberOfToppings(numberOfToppings)) {
            throw new IllegalArgumentException(INVALID_TOPPINGS_COUNT_MESSAGE);
        }

        Dough dough = new Dough(doughType, bakeType, weight);

        return new Pizza(name, dough, numberOfToppings);
    }

    private static boolean isValidNumberOfToppings(int numberOfToppings) {
        return numberOfToppings > -1 && numberOfToppings <= 10;
    }
}
