package wildFarm.animal;

import wildFarm.food.Food;

public class Cat extends Feline {
    private String breed;

    public Cat(String name, double weight, String livingRegion, String breed) {
        super(name, weight, livingRegion);
        this.setBreed(breed);
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public String toString() {
        return this.getAnimalType() + "[" + this.getName() + ", "
                + this.getBreed() + ", "
                + df.format(this.getWeight())
                + ", " + this.getLivingRegion() + ", " + this.getFoodEaten() + "]";
    }

    private String getBreed() {
        return this.breed;
    }

}
