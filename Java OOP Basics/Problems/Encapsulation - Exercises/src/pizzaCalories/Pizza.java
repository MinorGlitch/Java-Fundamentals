package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int toppingsCount;

    private static final String INVALID_PIZZA_NAME_MESSAGE = "Pizza name should be between 1 and 15 symbols.";

    public Pizza(String name, Dough dough, int toppingsCount) {
        this.setName(name);
        this.dough = dough;
        this.toppings = new ArrayList<>();
        this.toppingsCount = toppingsCount;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException(INVALID_PIZZA_NAME_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public int getToppingsCount() {
        return this.toppingsCount;
    }

    public double getTotalPizzaCalories() {
        double calories = 0.0D;

        calories += dough.getTotalCalories();

        for (Topping topping : toppings) {
            calories += topping.getTotalCalories();
        }

        return calories;
    }
}
