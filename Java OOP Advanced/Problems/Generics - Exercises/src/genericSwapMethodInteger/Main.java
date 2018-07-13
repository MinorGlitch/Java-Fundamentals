package genericSwapMethodInteger;

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

        List<Box<Integer>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boxes.add(new Box<>(Integer.valueOf(reader.readLine())));
        }

        int[] swapIndexes = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();


        swap(boxes, swapIndexes);

        boxes.forEach(b -> System.out.println(b.toString()));
    }

    private static <T> void swap(List<Box<T>> boxes, int[] indexes) {
        Box<T> box = boxes.get(indexes[0]);
        boxes.set(indexes[0], boxes.get(indexes[1]));
        boxes.set(indexes[1], box);
    }
}
