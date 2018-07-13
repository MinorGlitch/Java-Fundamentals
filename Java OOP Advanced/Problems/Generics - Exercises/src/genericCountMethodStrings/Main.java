package genericCountMethodStrings;

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

        String item = reader.readLine();

        System.out.println(count(boxes, item));
    }

    private static <T extends Comparable<T>> long count(List<Box<T>> items, T itemToCompare) {
        return items.stream().filter(i -> i.item.compareTo(itemToCompare) > 0).count();
    }
}
