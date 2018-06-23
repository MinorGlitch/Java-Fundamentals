package mordorsCrueltyPlan;

import mordorsCrueltyPlan.foods.Food;

import java.util.List;

public class Mood {
    private String mood;

    public Mood() { }

    public String getMood() {
        return mood;
    }

    public void setMood(List<Food> foods) {
        int totalHappiness = calculateHappiness(foods);

        if (totalHappiness < -5) {
            this.mood = "Angry";
        } else if (totalHappiness >= -5 && totalHappiness <= 0) {
            this.mood = "Sad";
        } else if (totalHappiness >= 0 && totalHappiness <= 15) {
            this.mood = "Happy";
        } else {
            this.mood = "JavaScript";
        }
    }

    public int calculateHappiness(List<Food> foods) {
        return foods.stream().mapToInt(Food::getHappiness).sum();
    }
}
