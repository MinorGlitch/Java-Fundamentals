package genericSwapMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        List<Box<String>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boxes.add(new Box<>(reader.readLine()));
        }

        int[] swapIndexes = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();



        boxes.forEach(b -> System.out.println(b.toString()));
    }

    private static void swap(List<List<? extends Box>> boxes, int[] indexes) {

    }
}
