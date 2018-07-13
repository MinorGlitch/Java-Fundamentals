package threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Threeuple<?, ?, ?>> threeuples = new ArrayList<>();

        String[] lineArgs = reader.readLine().split(" ");

        Threeuple<String, String, String> first = createTuple(lineArgs[0], lineArgs[1], lineArgs[2], lineArgs[3]);

        lineArgs = reader.readLine().split(" ");

        Threeuple<String, Integer, Boolean> second = createTuple(lineArgs[0],
                Integer.valueOf(lineArgs[1]), lineArgs[2]);

        lineArgs = reader.readLine().split(" ");

        Threeuple<String, Double, String> third = createTuple(lineArgs[0],
                Double.valueOf(lineArgs[1]), lineArgs[2]);

        threeuples.add(first);
        threeuples.add(second);
        threeuples.add(third);

        threeuples.forEach(System.out::println);
    }

    private static Threeuple<String, String, String> createTuple(String firstName, String lastName,
                                                                 String address, String city) {
        return new Threeuple<>(firstName + " " + lastName, address, city);
    }

    private static Threeuple<String, Integer, Boolean> createTuple(String name, int litres, String drunkOrNot) {
        return new Threeuple<>(name, litres, drunkOrNot.equals("drunk"));
    }

    private static Threeuple<String, Double, String> createTuple(String name, double balance, String bankName) {
        return new Threeuple<>(name, balance, bankName);
    }
}
