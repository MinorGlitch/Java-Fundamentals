package mordorsCrueltyPlan;

import mordorsCrueltyPlan.foods.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] foods = reader.readLine().split("\\s+");

        Gandalf gandalf = new Gandalf();


        for (String food : foods) {
            gandalf.addFood(createFood(food));
        }

        gandalf.setMood();
        System.out.println(gandalf.toString());
    }

    private static Food createFood(String food) {
        switch (food.toLowerCase()) {
            case "cram":
                return new Cram();
            case "lembas":
                return new Lembas();
            case "apple":
                return new Apple();
            case "melon":
                return new Melon();
            case "honeycake":
                return new HoneyCake();
            case "mushrooms":
                return new Mushrooms();
            default:
                return new Food(-1);
        }
    }
}
