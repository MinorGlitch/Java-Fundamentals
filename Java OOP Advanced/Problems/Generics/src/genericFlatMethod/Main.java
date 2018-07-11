package genericFlatMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 1, 2, 3);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.2, 3.2);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, ints, doubles);

        List<Number> dest = new ArrayList<>();

        ListUtils.flatten(dest, jagged);

        System.out.println(dest);
    }

}
