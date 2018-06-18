package animalFarm;

import java.text.DecimalFormat;

public class Chicken {
    private String name;
    private double eggsPerDay;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
        this.setEggsPerDay(this.getAge());
    }

    private int getAge() {
        return this.age;
    }

    private void setName(String name) {
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setEggsPerDay(int age) {
        double eggs = 0;

        if (age < 6) {
            eggs = 2;
        } else if (age >= 6 || age < 11) {
            eggs = 1;
        } else {
            eggs = 0.75;
        }

        this.eggsPerDay = eggs;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.#");
        return "Chicken " + this.getName() + " (age " + this.getAge() + ") can produce "
                + df.format(this.getEggsPerDay()) + " eggs per day.";
    }

    private double getEggsPerDay() {
        return this.eggsPerDay;
    }

    private String getName() {
        return this.name;
    }
}
