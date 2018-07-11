package genericFlatMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ListUtils {
    private ListUtils() { }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        T min = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(min) < 0) {
                min = list.get(i);
            }
        }

        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        T max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }

        return max;
    }

    public static <T> List<Integer> getNullIndices(List<T> list) {
        List<Integer> nullIndices = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                nullIndices.add(i);
            }
        }

        return nullIndices;
    }

    public static <T extends Number> void flatten(List<? super T> dest, List<List<? extends T>> source) {
        for (List<? extends T> nestedList : source) {
            dest.addAll(nestedList);
        }
    }
}
