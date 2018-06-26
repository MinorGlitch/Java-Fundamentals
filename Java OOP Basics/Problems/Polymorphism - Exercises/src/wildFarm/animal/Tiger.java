package wildFarm.animal;

import wildFarm.food.Food;

public class Tiger extends Feline {
    public Tiger(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eat(Food food) throws IllegalArgumentException {
        if (food.getFoodType().equals("Vegetable")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }

        super.eat(food);
    }
}
