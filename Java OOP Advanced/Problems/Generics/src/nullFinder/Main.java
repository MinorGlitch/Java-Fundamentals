package nullFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 1, 2, 3, null, 4, null, 5);

        List<Integer> nullIndexes = ListUtils.getNullIndices(ints);

        System.out.println(nullIndexes);
    }
}
