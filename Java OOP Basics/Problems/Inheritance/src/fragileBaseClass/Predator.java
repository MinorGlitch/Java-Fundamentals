package fragileBaseClass;

public class Predator extends Animal {
    private int health;

    public void feed(Food food) {
        eat(food);
        health++;
    }
}
