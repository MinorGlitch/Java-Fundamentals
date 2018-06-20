package pizzaCalories;

import java.util.Map;

public class Dough {
    private String flourType;
    private String bakeType;
    private double doughModifier;
    private double bakeModifier;
    private double weight;

    private static final Map<String, Double> DOUGH_MODIFIERS =
            Map.of("White", 1.5, "Wholegrain", 1.0, "Crispy",
                    0.9, "Chewy", 1.1, "Homemade", 1.0);

    private static final String INVALID_DOUGH_TYPE = "Invalid type of dough.";
    private static final String INVALID_DOUGH_WEIGHT = "Dough weight should be in the range [1..200].";
    private static final double CALORIES_PER_GRAM_DEFAULT = 2;

    public Dough(String flourType, String bakeType, double weight) {
        this.setFlourType(flourType);
        this.setBakeType(bakeType);
        this.setModifier(flourType, bakeType);
        this.setWeight(weight);
    }

    private void setModifier(String flourType, String bakeType) {
        this.doughModifier = DOUGH_MODIFIERS.get(flourType);
        this.bakeModifier = DOUGH_MODIFIERS.get(bakeType);
    }

    private void setFlourType(String flourType) {
        if (isNotValidType(flourType)) {
            throw new IllegalArgumentException(INVALID_DOUGH_TYPE);
        }
        this.flourType = flourType;
    }

    private void setBakeType(String bakeType) {
        if (isNotValidType(flourType)) {
            throw new IllegalArgumentException(INVALID_DOUGH_TYPE);
        }
        this.bakeType = bakeType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException(INVALID_DOUGH_WEIGHT);
        }
        this.weight = weight;
    }


    private boolean isNotValidType(String doughArg) {
        return !DOUGH_MODIFIERS.containsKey(doughArg);
    }

    public double getTotalCalories() {
        return (CALORIES_PER_GRAM_DEFAULT * this.weight) * this.doughModifier * this.bakeModifier;
    }
}
