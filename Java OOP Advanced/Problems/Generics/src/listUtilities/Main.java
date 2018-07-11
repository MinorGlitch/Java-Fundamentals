package listUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 1, 2, 3, 4, 5);

        int min = ListUtils.getMin(ints);
        int max = ListUtils.getMax(ints);

        System.out.println(min);
        System.out.println(max);
    }
}
