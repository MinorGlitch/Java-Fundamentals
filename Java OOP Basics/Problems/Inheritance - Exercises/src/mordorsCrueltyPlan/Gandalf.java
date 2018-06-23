package mordorsCrueltyPlan;

import mordorsCrueltyPlan.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Gandalf {
    private List<Food> foods = new ArrayList<>();
    private Mood mood;

    public Gandalf() {
        foods = new ArrayList<>();
        mood = new Mood();
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }

    public void setMood() {
        this.mood.setMood(this.foods);
    }

    @Override
    public String toString() {
        return this.mood.calculateHappiness(this.foods) + "\n" + this.mood.getMood();
    }
}
