package wildFarm.animal;

import wildFarm.food.Food;

public class Zebra extends Mammal {
    public Zebra(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "Zs";
    }

    @Override
    public void eat(Food food) {
        if (!food.getFoodType().equals("Vegetable")) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
            super.eat(food);
    }
}
