package pizzaCalories;

import java.util.LinkedHashMap;
import java.util.Map;

public class Topping {
    private String name;
    private double weight;
    private double modifier;

    private static final double CALORIES_PER_GRAM_DEFAULT = 2;
    private static final String INVALID_TOPPING_NAME = "Cannot place %s on top of your pizza.";
    private static final String INVALID_TOPPING_WEIGHT = "%s weight should be in the range [1..50].";

    private static final Map<String, Double> TOPPINGS_MODIFIERS =
            Map.of("Meat", 1.2, "Veggies", 0.8, "Cheese", 1.1, "Sauce", 0.9);

    public Topping(String name, double weight) {
        this.setName(name);
        this.setWeight(weight);
        this.modifier = TOPPINGS_MODIFIERS.get(name);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format(INVALID_TOPPING_WEIGHT, name));
        }
        this.weight = weight;
    }

    private void setName(String name) {
        if (!TOPPINGS_MODIFIERS.containsKey(name)) {
            throw new IllegalArgumentException(String.format(INVALID_TOPPING_NAME, name));
        }
        this.name = name;
    }

    public double getTotalCalories() {
        return (CALORIES_PER_GRAM_DEFAULT * this.weight) * this.modifier;
    }
}
