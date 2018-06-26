package wildFarm.animal;

import wildFarm.food.Food;

public class Mouse extends Mammal {
    public Mouse(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    public void eat(Food food) {
        if (!food.getFoodType().equals("Vegetable")) {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.eat(food);
    }
}
