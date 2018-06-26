package wildFarm.animal;

import wildFarm.food.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String name;
    private double weight;
    private int foodEaten;

    protected static final DecimalFormat df = new DecimalFormat("#.##");

    protected Animal(String name, double weight) {
        this.setName(name);
        this.setWeight(weight);
    }

    protected String getName() {
        return name;
    }

    protected double getWeight() {
        return weight;
    }

    protected int getFoodEaten() {
        return foodEaten;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    private void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public String getAnimalType() {
        return this.getClass().getSimpleName();
    }

    public abstract String makeSound();

    public void eat(Food food) {
        this.setFoodEaten(food.getQuantity());
    }


}
