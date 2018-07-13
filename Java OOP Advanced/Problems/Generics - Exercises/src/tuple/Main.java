package tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Tuple<?, ?>> tuples = new ArrayList<>();

        String[] lineArgs = reader.readLine().split(" ");

        Tuple<String, String> first = createTuple(lineArgs[0], lineArgs[1], lineArgs[2]);

        lineArgs = reader.readLine().split(" ");

        Tuple<String, Integer> second = createTuple(lineArgs[0], Integer.valueOf(lineArgs[1]));

        lineArgs = reader.readLine().split(" ");

        Tuple<Integer, Double> third = createTuple(Integer.valueOf(lineArgs[0]), Double.valueOf(lineArgs[1]));

        tuples.add(first);
        tuples.add(second);
        tuples.add(third);

        tuples.forEach(System.out::println);
    }

    private static Tuple<String, String> createTuple(String firstName, String lastName, String address) {
        return new Tuple<>(firstName + " " + lastName, address);
    }

    private static Tuple<String, Integer> createTuple(String name, int litres) {
        return new Tuple<>(name, litres);
    }

    private static Tuple<Integer, Double> createTuple(int integer, double db) {
        return new Tuple<>(integer, db);
    }
}
