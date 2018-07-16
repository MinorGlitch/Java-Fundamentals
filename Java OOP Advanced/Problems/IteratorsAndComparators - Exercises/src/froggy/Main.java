package froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = Arrays.stream(reader.readLine().split(", | "))
                .map(Integer::valueOf).toArray(Integer[]::new);

        Lake lake = new Lake(numbers);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < lake.getNumbers().size(); i += 2) {
            result.add(lake.getNumbers().get(i).toString());
        }

        for (int i = 1; i < lake.getNumbers().size(); i += 2) {
            result.add(lake.getNumbers().get(i).toString());
        }

        System.out.println(String.join(", ", result));
    }
}
